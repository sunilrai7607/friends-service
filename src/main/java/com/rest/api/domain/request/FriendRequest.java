package com.rest.api.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class FriendRequest implements Serializable {

    private static final long serialVersionUID = -2057078504072773376L;

    private String firstName;

    private String lastName;

    private String emailId;

    private String address1;

    private String address2;

    private String zip;

    private String state;

}
