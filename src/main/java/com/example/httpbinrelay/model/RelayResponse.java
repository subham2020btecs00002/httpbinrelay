package com.example.httpbinrelay.model;

import lombok.Data;

@Data
public class RelayResponse {
    private String data;
    private Object json;
    private Object headers;
    private String url;
}