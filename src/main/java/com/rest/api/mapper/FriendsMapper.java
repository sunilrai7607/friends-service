package com.rest.api.mapper;

import com.rest.api.domain.FriendDto;
import com.rest.api.domain.entity.FriendEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class FriendsMapper {


    public abstract FriendDto toDto(FriendEntity friendsEntity);

    public abstract FriendEntity toEntity(FriendDto friendsDto);


}
