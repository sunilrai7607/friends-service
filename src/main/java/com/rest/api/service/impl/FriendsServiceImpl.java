package com.rest.api.service.impl;

import com.rest.api.common.exception.ResourceNotFoundException;
import com.rest.api.domain.FriendDto;
import com.rest.api.domain.entity.FriendEntity;
import com.rest.api.domain.request.FriendRequest;
import com.rest.api.domain.response.FriendResponse;
import com.rest.api.mapper.FriendDtoMapper;
import com.rest.api.mapper.FriendEntityMapper;
import com.rest.api.mapper.FriendResponseMapper;
import com.rest.api.repository.FriendRepository;
import com.rest.api.service.FriendsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FriendsServiceImpl implements FriendsService {


    private final FriendRepository friendsRepository;
    private final FriendEntityMapper friendEntityMapper;
    private final FriendResponseMapper friendResponseMapper;


    @Autowired
    public FriendsServiceImpl(FriendRepository friendsRepository, FriendEntityMapper friendEntityMapper, FriendResponseMapper friendResponseMapper) {

        this.friendsRepository = friendsRepository;
        this.friendEntityMapper = friendEntityMapper;
        this.friendResponseMapper = friendResponseMapper;
    }


    @Override
    public List<FriendDto> findAll() {
        return friendsRepository
                .findAll()
                .stream()
                .map(FriendDtoMapper.INSTANCE::map)
                .collect(Collectors.toList());
    }

    /**
     * Method to find friend by Id
     *
     * @param id
     * @return
     */
    @Override
    public FriendDto findById(Long id) {
        return FriendDtoMapper.INSTANCE
                .map(friendsRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Friend not found for this id :: " + id)
                        )
                );
    }

    /**
     * Method to create friend
     * Method to create friend
     *
     * @param friendRequest
     * @return
     */
    @Override
    public FriendResponse createFriend(FriendRequest friendRequest) {
        FriendEntity temp = friendEntityMapper.transform(friendRequest);
        log.info("FriendEntity : {} ", temp);
        return friendResponseMapper.updateMap(friendsRepository.save(friendEntityMapper.transform(friendRequest)));
    }

    /**
     * Method to update the friend
     *
     * @param id
     * @param friendRequest
     * @return
     */
    @Override
    public FriendResponse updateFriend(Long id, FriendRequest friendRequest) {
        FriendEntity friendsEntity = friendsRepository
                .save(friendEntityMapper
                        .map(
                                friendRequest,
                                friendsRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + id)
                                        )
                        )
                );
        log.info("Updated Friends object {} ", friendsEntity);
        return friendResponseMapper.updateMap(friendsEntity);
    }

    /**
     * Method to delete friend
     *
     * @param id
     * @return
     */
    @Override
    public FriendResponse deleteFriend(Long id) {
        FriendEntity friendEntity = friendsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + id));
        friendsRepository.delete(friendEntity);
        return friendResponseMapper.deleteMap(friendEntity);
    }
}
