package pt.com.pascoal.axonexample.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public final class CustomHttpUtil {
    private CustomHttpUtil() {
        //no instance of utility class my friend.
    }

    public static HttpHeaders getResponseHeader(final String id) {
        HttpHeaders responseHeader = new HttpHeaders();
        URI newPEventUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        responseHeader.setLocation(newPEventUri);
        return responseHeader;
    }
}
