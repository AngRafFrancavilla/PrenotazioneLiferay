package prenotazione.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import prenotazione.model.Prenotazione;

public class PrenotazioneDataOrderByComparator extends OrderByComparator<Prenotazione> {

    private final boolean ascending;

    public PrenotazioneDataOrderByComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Prenotazione p1, Prenotazione p2) {
        if (p1.getData() == null || p2.getData() == null) return 0;
        int value = p1.getData().compareTo(p2.getData());
        return ascending ? value : -value;
    }

    @Override
    public String getOrderBy() {
        return "data " + (ascending ? "ASC" : "DESC");
    }

    @Override
    public String[] getOrderByFields() {
        return new String[] {"data"};
    }

    @Override
    public boolean isAscending() {
        return ascending;
    }
}
