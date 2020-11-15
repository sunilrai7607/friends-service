package com.rest.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FriendDto {

    public long id;
    public String firstName;
    public String lastName;
    public String emailId;
    private String uuid;
    private String address1;

    private String address2;

    private String zip;

    private String state;

    public FriendDto(long id) {
        this.id = id;
    }
}
