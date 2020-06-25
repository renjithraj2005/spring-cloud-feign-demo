package com.demo.openfeign.feign;

import com.demo.openfeign.exception.CustomErrorDecoder;
import feign.Client;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.http.entity.ContentType;


@Configuration
public class ClientConfiguration {

    //Documentation https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html

    @Autowired(required = false)
    private HttpClient httpClient;

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public Client client() {
        if (httpClient != null) {
            return new ApacheHttpClient(httpClient);
        }
        return new ApacheHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}
