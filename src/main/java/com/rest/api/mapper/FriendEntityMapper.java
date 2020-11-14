package com.rest.api.mapper;

import com.rest.api.domain.entity.FriendEntity;
import com.rest.api.domain.request.FriendRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FriendEntityMapper {

    default FriendEntity map(FriendRequest friendRequest, FriendEntity friendsEntity) {
        friendsEntity.setEmailId(friendRequest.getEmailId());
        friendsEntity.setLastName(friendRequest.getLastName());
        friendsEntity.setFirstName(friendRequest.getFirstName());
        return friendsEntity;
    }


    @Mapping(target = "firstName", source = "friendRequest.firstName")
    @Mapping(target = "lastName", source = "friendRequest.lastName")
    @Mapping(target = "emailId", source = "friendRequest.emailId")
    @Mapping(target = "address1", source = "friendRequest.address1")
    @Mapping(target = "address2", source = "friendRequest.address2")
    @Mapping(target = "zip", source = "friendRequest.zip")
    @Mapping(target = "state", source = "friendRequest.state")
    FriendEntity transform(FriendRequest friendRequest);
}
