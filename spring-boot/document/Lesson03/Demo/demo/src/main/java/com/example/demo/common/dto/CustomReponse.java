package com.example.demo.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonPropertyOrder({"data", "message"}) // Đảm bảo Json đầu ra có data trước, message sau
@JsonInclude(JsonInclude.Include.NON_NULL) //Dữ liệu nào null thì sẽ không xuất hiện
public class CustomReponse<T> implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private String message;

    public CustomReponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public CustomReponse(String message) {
        this.message = message;
    }

    public CustomReponse(T data) {
        this.data = data;
    }
}
