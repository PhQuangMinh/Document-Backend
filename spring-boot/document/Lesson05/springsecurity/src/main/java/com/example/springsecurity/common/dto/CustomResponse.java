package com.example.springsecurity.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonPropertyOrder({"data", "message"}) // Đảm bảo Json đầu ra có data trước, message sau
@JsonInclude(JsonInclude.Include.NON_NULL) //Dữ liệu nào null thì sẽ không xuất hiện
public class CustomResponse<T> implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private String message;

    public CustomResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public CustomResponse(String message) {
        this.message = message;
    }

    public CustomResponse(T data) {
        this.data = data;
    }
}
