package com.rest.api.service;

import com.rest.api.domain.FriendDto;
import com.rest.api.domain.request.FriendRequest;
import com.rest.api.domain.response.FriendResponse;

import java.util.List;

public interface FriendsService {

    /**
     * Method to findAll friends
     *
     * @return
     */
    List<FriendDto> findAll();

    /**
     * Method to find friend by Id
     *
     * @param id
     * @return
     */
    FriendDto findById(Long id);

    /**
     * Method to create friend
     * Method to create friend
     *
     * @param friendRequest
     * @return
     */
    FriendResponse createFriend(FriendRequest friendRequest);

    /**
     * Method to update the friend
     *
     * @param id
     * @param friendRequest
     * @return
     */
    FriendResponse updateFriend(Long id, FriendRequest friendRequest);

    /**
     * Method to delete friend
     *
     * @param id
     * @return
     */
    FriendResponse deleteFriend(Long id);
}
