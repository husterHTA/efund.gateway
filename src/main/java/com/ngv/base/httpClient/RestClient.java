package com.ngv.base.httpClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestClient {

  @Autowired
  @Qualifier("restTemplate")
  private RestTemplate restTemplate;
  int count = 0;

  public <T> T execute(String urlTemplate, HttpMethod method, HttpEntity<Object> eHeader,
      Class<T> ofClass) {
    ResponseEntity<T> responseEntity = restTemplate.exchange(urlTemplate, method, eHeader,
        ofClass);
    log.info("|Execute API SUCCESS result|" + responseEntity.getBody());
    return responseEntity.getBody();

  }

  public <T> T executeWithRetry(String urlTemplate, HttpMethod method, HttpEntity<Object> eHeader,
      Class<T> ofClass) {
    try {
      execute(urlTemplate, method, eHeader,
          ofClass);
    } catch (Exception e) {
      count++;
      int retry = 3;
      if (count < retry) {
        execute(urlTemplate, method, eHeader,
            ofClass);
      }
    }
    return null;
  }
}
