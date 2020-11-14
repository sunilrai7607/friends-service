package com.rest.api.mapper;

import com.rest.api.domain.entity.FriendEntity;
import com.rest.api.domain.response.FriendResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendResponseMapper {

    default FriendResponse updateMap(FriendEntity friendsEntity) {
        FriendResponse friendResponse = new FriendResponse();
        friendResponse.setId(friendsEntity.getId());
        friendResponse.setMessage("Successfully Updated");
        return friendResponse;
    }

    default FriendResponse deleteMap(FriendEntity friendsEntity) {
        FriendResponse friendResponse = new FriendResponse();
        friendResponse.setId(friendsEntity.getId());
        friendResponse.setMessage("Deleted Successfully");
        return friendResponse;
    }
}
