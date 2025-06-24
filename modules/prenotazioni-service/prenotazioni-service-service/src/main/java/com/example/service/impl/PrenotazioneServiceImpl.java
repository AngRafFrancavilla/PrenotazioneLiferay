package com.example.service.impl;

import com.example.dto.PrenotazioneDTO;
import com.example.service.PrenotazioneService;

import org.osgi.service.component.annotations.Component;

@Component(
    service = PrenotazioneService.class
)
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Override
    public void processaPrenotazione(PrenotazioneDTO dto) {
        System.out.println("Prenotazione ricevuta:");
        System.out.println("Email: " + dto.getEmail());
        System.out.println("Data: " + dto.getData());
        System.out.println("Ora Entrata: " + dto.getOraFine());
        System.out.println("Ora Uscita: " + dto.getOraFine());
        System.out.println("ID Postazione: " + dto.getPostazioneId());
    }
}
