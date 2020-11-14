package com.rest.api.domain.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class FriendResponse implements Serializable {

    private Long Id;
    private String message;
}
