package com.bcnc.challenge.adapter.in.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String message;
}