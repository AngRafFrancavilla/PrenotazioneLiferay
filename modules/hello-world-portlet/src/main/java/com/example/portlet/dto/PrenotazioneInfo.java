package com.example.portlet.dto;

import java.util.Date;

public class PrenotazioneInfo {

    private long prenotazioneId;
    private String nome;
    private String cognome;
    private String email;
    private Date data;
    private String oraInizio;
    private String oraFine;

    public PrenotazioneInfo() {
    }

    public PrenotazioneInfo(long prenotazioneId, String nome, String cognome, String email, Date data, String oraInizio, String oraFine) {
        this.prenotazioneId = prenotazioneId;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    public long getPrenotazioneId() {
        return prenotazioneId;
    }

    public void setPrenotazioneId(long prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }
}
