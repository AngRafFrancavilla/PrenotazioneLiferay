package com.example.dto;

import java.io.Serializable;
import javax.portlet.ActionRequest;
import com.liferay.portal.kernel.util.ParamUtil;

public class PrenotazioneDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String data;
    private String oraInizio;
    private String oraFine;
    private String postazioneId;

    public PrenotazioneDTO() {
    }

    public PrenotazioneDTO(
        String email,
        String data,
        String oraInizio,
        String oraFine,
        String postazioneId
    ) {
        this.email = email;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.postazioneId = postazioneId;
    }

    // metodo per popolare il DTO direttamente dall'ActionRequest
    public static PrenotazioneDTO fromRequest(ActionRequest request) {
        String email = ParamUtil.getString(request, "email");
        String data = ParamUtil.getString(request, "data");
        String oraInizio = ParamUtil.getString(request, "oraInizio");
        String oraFine = ParamUtil.getString(request, "oraFine");
        String postazioneId = ParamUtil.getString(request, "postazioneId");

        return new PrenotazioneDTO(email, data, oraInizio, oraFine, postazioneId);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public String getPostazioneId() {
        return postazioneId;
    }

    public void setPostazioneId(String postazioneId) {
        this.postazioneId = postazioneId;
    }

    @Override
    public String toString() {
        return "PrenotazioneDTO{" +
            "email='" + email + '\'' +
            ", data='" + data + '\'' +
            ", oraInizio='" + oraInizio + '\'' +
            ", oraFine='" + oraFine + '\'' +
            ", postazioneId='" + postazioneId + '\'' +
            '}';
    }
}
