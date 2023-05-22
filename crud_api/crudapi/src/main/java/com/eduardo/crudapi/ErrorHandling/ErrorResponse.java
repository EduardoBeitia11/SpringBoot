package com.eduardo.crudapi.ErrorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int status;

    private String message;

    private long timeStamp;
}
