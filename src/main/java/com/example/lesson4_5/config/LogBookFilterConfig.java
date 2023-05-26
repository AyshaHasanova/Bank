package com.example.lesson4_5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.DefaultHttpLogFormatter;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.Logbook;

import static org.zalando.logbook.Conditions.*;
import static org.zalando.logbook.HeaderFilters.removeHeaders;
import static org.zalando.logbook.json.JsonBodyFilters.accessToken;


@Configuration
public class LogBookFilterConfig {

    @Bean
    public Logbook logBook() {
        return Logbook.builder ()
                .condition (exclude (
                        requestTo ("/"),
                        requestTo ("/webjars/**"),
                        requestTo ("/csrf"),
                        requestTo ("/v2/**"),
                        requestTo ("/swagger**"),
                        contentType ("application/octet-stream")))
                .headerFilter (
                        removeHeaders ("cookie", "content-length", "accept-encoding", "accept-language", "connection", "Accept", "dnt", "Transfer-Encoding"))
                .bodyFilter (accessToken ())
                .sink (
                        new DefaultSink (
                                new DefaultHttpLogFormatter (),
                                new SimpleHttpLogWriter ()
                        )
                )
                .build ();
    }
}
