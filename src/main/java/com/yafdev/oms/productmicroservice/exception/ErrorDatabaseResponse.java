package com.yafdev.oms.productmicroservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDatabaseResponse {

    private int status;
    private String message;
    private String field;

    public ErrorDatabaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
