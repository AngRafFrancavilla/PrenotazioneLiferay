package com.example.rest;

import com.example.dto.PrenotazioneDTO;

public interface PrenotazioneRestClient {

    int inviaPrenotazione(PrenotazioneDTO prenotazione) throws Exception;
}
