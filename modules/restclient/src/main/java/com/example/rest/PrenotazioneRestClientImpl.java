package com.example.rest;

import com.example.dto.PrenotazioneDTO;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component(
    service = PrenotazioneRestClient.class
)
public class PrenotazioneRestClientImpl implements PrenotazioneRestClient {

	private static final String BFF_URL = "http://localhost:8086/prenotazioni/inserisci";

    @Override
    public int inviaPrenotazione(PrenotazioneDTO dto) throws Exception {
        URL url = new URL(BFF_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("email", dto.getEmail());
        json.put("data", dto.getData());
        json.put("oraInizio", dto.getOraInizio());
        json.put("oraFine", dto.getOraFine());
        json.put("postazioneId", dto.getPostazioneId());

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();

        connection.disconnect();
        return responseCode;
    }
}
