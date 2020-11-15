package com.rest.api.mapper;

import com.rest.api.domain.entity.FriendEntity;
import com.rest.api.domain.request.FriendRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
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
    @Mapping(target = "uuid", expression = "java( UUID.randomUUID().toString() )")
    FriendEntity transform(FriendRequest friendRequest);

    @AfterMapping
    default void beforeMapping(@MappingTarget FriendEntity target, FriendRequest source) {

        switch (source.getState()) {
            case "PA":
                target.setState("Pennsylvania");
                break;
            case "NJ":
                target.setState("New Jersey");
                break;
            default:
                target.setState(source.getState());
                break;

        }
    }
}
