package com.referral.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    public enum STATUS{
        SUCCESS("SUCCESS"),
        ERROR("ERROR");
        private String value;

        STATUS(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    T payload;
    String message = STATUS.SUCCESS.getValue();

    public ApiResponse(T payload, String message) {
        this.payload = payload;
        this.message = message;
    }

    public ApiResponse(T payload) {
        this.payload = payload;
    }

    public ApiResponse(String message) {
        this.message = message;
    }
}
