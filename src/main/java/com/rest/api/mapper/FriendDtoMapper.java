package com.rest.api.mapper;

import com.rest.api.domain.FriendDto;
import com.rest.api.domain.entity.FriendEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class FriendDtoMapper implements BaseMapper<FriendEntity, FriendDto> {

    public static final FriendDtoMapper INSTANCE = Mappers.getMapper(FriendDtoMapper.class);

    @Mapping(target = "id", source = "input.id")
    @Mapping(target = "firstName", source = "input.firstName")
    @Mapping(target = "lastName", source = "input.lastName")
    @Mapping(target = "emailId", source = "input.emailId")
    @Mapping(target = "address1", source = "input.address1")
    @Mapping(target = "address2", source = "input.address2")
    @Mapping(target = "zip", source = "input.zip")
    @Mapping(target = "state", source = "input.state")
    @Mapping(target = "uuid", source = "input.uuid")
    public abstract FriendDto map(FriendEntity input);
}
