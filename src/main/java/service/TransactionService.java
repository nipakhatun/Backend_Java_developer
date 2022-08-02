package service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class TransactionService {

    private <T> ResponseEntity<T> getResponse(HttpMethod method, String route, Class<T> responseType) {
        return getResponse( method, route, responseType, "");
    }

    private <T, Z> ResponseEntity<T> getResponse(HttpMethod method, String route, Class<T> responseType, Z request) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Z> httpEntity = new HttpEntity<>(request, httpHeaders);

        if (route.endsWith("/")) {
            route += "?";
        }

        ResponseEntity<T> responseEntity = restTemplate.exchange(
                route,
                method,
                httpEntity,
                responseType
        );

        System.out.println(method + " " + route);
        System.out.println(httpEntity);
        System.out.println(responseEntity);

        return responseEntity;
    }
}
