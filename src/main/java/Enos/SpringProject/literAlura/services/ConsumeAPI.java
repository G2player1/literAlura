package Enos.SpringProject.literAlura.services;

import Enos.SpringProject.literAlura.exceptions.CantGetWebDataException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumeAPI {

    public String getData(String address) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(address, HttpMethod.GET, null, String.class);
        if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            throw new CantGetWebDataException("No content find");
        } else {
            String responseBody = response.getBody();
            if (responseBody != null && !responseBody.isEmpty()) {
                return responseBody;
            } else {
                throw new CantGetWebDataException("the body is empty");
            }
        }
    }

}
