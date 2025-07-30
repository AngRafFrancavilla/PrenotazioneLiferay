package com.example.portlet.rendercommand;

import com.example.constants.HelloWorldPortletKeys;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import prenotazione.model.Prenotazione;
import prenotazione.service.PrenotazioneLocalService;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HelloWorldPortletKeys.HELLOWORLD,
        "mvc.command.name=/user-stats"
    },
    service = MVCRenderCommand.class
)
public class UserStatsRenderCommand implements MVCRenderCommand {

    @Reference
    private PrenotazioneLocalService prenotazioneLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        
        // Ottieni tutte le prenotazioni
        List<Prenotazione> tuttePrenotazioni = prenotazioneLocalService.getPrenotaziones(-1, -1);
        
        // Filtra le prenotazioni dell'anno corrente
        Calendar cal = Calendar.getInstance();
        int annoCorrente = cal.get(Calendar.YEAR);
        
        List<Prenotazione> prenotazioniAnnoCorrente = tuttePrenotazioni.stream()
            .filter(p -> {
                Calendar prenCal = Calendar.getInstance();
                prenCal.setTime(p.getData());
                return prenCal.get(Calendar.YEAR) == annoCorrente;
            })
            .collect(Collectors.toList());
        
        // Raggruppa per email per creare le statistiche utente
        Map<String, List<Prenotazione>> prenotazioniPerEmail = prenotazioniAnnoCorrente.stream()
            .collect(Collectors.groupingBy(Prenotazione::getEmail));
        
        List<UserStats> userStatsList = new ArrayList<>();
        
        for (Map.Entry<String, List<Prenotazione>> entry : prenotazioniPerEmail.entrySet()) {
            String email = entry.getKey();
            List<Prenotazione> prenotazioniUtente = entry.getValue();
            
            // Estrai nome e cognome dall'email (assumendo formato nome.cognome@domain.com)
            String[] emailParts = email.split("@")[0].split("\\.");
            String nome = emailParts.length > 0 ? capitalizeFirst(emailParts[0]) : "";
            String cognome = emailParts.length > 1 ? capitalizeFirst(emailParts[1]) : "";
            
            int numeroPrenotazioni = prenotazioniUtente.size();
            
            // Calcola giorni trascorsi dal 1° gennaio
            Calendar inizioAnno = Calendar.getInstance();
            inizioAnno.set(annoCorrente, Calendar.JANUARY, 1, 0, 0, 0);
            inizioAnno.set(Calendar.MILLISECOND, 0);
            
            Calendar oggi = Calendar.getInstance();
            oggi.set(Calendar.HOUR_OF_DAY, 23);
            oggi.set(Calendar.MINUTE, 59);
            oggi.set(Calendar.SECOND, 59);
            oggi.set(Calendar.MILLISECOND, 999);
            
            long differenzaMillis = oggi.getTimeInMillis() - inizioAnno.getTimeInMillis();
            int giorniTrascorsi = (int) (differenzaMillis / (1000 * 60 * 60 * 24)) + 1;
            
            boolean bisestile = new GregorianCalendar().isLeapYear(annoCorrente);
            int giorniTotaliAnno = bisestile ? 366 : 365;

            double percentualeAdOggi = giorniTrascorsi > 0 ? 
                (double) numeroPrenotazioni / giorniTrascorsi * 100 : 0.0;
            
            double percentualeNellAnno = 
                (double) numeroPrenotazioni / giorniTotaliAnno * 100;
            
            UserStats userStats = new UserStats();
            userStats.setNome(nome);
            userStats.setCognome(cognome);
            userStats.setEmail(email);
            userStats.setNumeroPrenotazioni(numeroPrenotazioni);
            userStats.setPercentualeAdOggi(percentualeAdOggi);
            userStats.setPercentualeNellAnno(percentualeNellAnno);
            userStats.setPrenotazioni(prenotazioniUtente);
            
            userStatsList.add(userStats);
        }

        String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "cognome");
        String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "asc");
        
        Comparator<UserStats> comparator = null;
        
        switch (orderByCol) {
            case "nome":
                comparator = Comparator.comparing(UserStats::getNome, String.CASE_INSENSITIVE_ORDER);
                break;
            case "cognome":
                comparator = Comparator.comparing(UserStats::getCognome, String.CASE_INSENSITIVE_ORDER);
                break;
            case "email":
                comparator = Comparator.comparing(UserStats::getEmail, String.CASE_INSENSITIVE_ORDER);
                break;
            case "numeroPrenotazioni":
                comparator = Comparator.comparing(UserStats::getNumeroPrenotazioni);
                break;
            case "percentualeAdOggi":
                comparator = Comparator.comparing(UserStats::getPercentualeAdOggi);
                break;
            case "percentualeNellAnno":
                comparator = Comparator.comparing(UserStats::getPercentualeNellAnno);
                break;
            default:
                comparator = Comparator.comparing(UserStats::getCognome, String.CASE_INSENSITIVE_ORDER);
        }
        
        if ("desc".equalsIgnoreCase(orderByType)) {
            comparator = comparator.reversed();
        }
        
        userStatsList = userStatsList.stream()
            .sorted(comparator)
            .collect(Collectors.toList());
 
        Calendar cal2 = Calendar.getInstance();
        int giornoAnno = cal2.get(Calendar.DAY_OF_YEAR);
        boolean bisestile = new GregorianCalendar().isLeapYear(annoCorrente);
        int giorniTotaliAnno = bisestile ? 366 : 365;
        
        renderRequest.setAttribute("userStatsList", userStatsList);
        renderRequest.setAttribute("annoCorrente", annoCorrente);
        renderRequest.setAttribute("giornoAnno", giornoAnno);
        renderRequest.setAttribute("giorniTotaliAnno", giorniTotaliAnno);
        renderRequest.setAttribute("bisestile", bisestile);
        
        return "/user_stats.jsp";
    }
    
    private String capitalizeFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    //classe interna per le statistiche utente
    public static class UserStats {
        private String nome;
        private String cognome;
        private String email;
        private int numeroPrenotazioni;
        private double percentualeAdOggi;
        private double percentualeNellAnno;
        private List<Prenotazione> prenotazioni;

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        
        public String getCognome() { return cognome; }
        public void setCognome(String cognome) { this.cognome = cognome; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public int getNumeroPrenotazioni() { return numeroPrenotazioni; }
        public void setNumeroPrenotazioni(int numeroPrenotazioni) { this.numeroPrenotazioni = numeroPrenotazioni; }
        
        public double getPercentualeAdOggi() { return percentualeAdOggi; }
        public void setPercentualeAdOggi(double percentualeAdOggi) { this.percentualeAdOggi = percentualeAdOggi; }
        
        public double getPercentualeNellAnno() { return percentualeNellAnno; }
        public void setPercentualeNellAnno(double percentualeNellAnno) { this.percentualeNellAnno = percentualeNellAnno; }
        
        public List<Prenotazione> getPrenotazioni() { return prenotazioni; }
        public void setPrenotazioni(List<Prenotazione> prenotazioni) { this.prenotazioni = prenotazioni; }
    }
}