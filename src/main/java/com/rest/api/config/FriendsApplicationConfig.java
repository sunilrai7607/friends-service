package com.rest.api.config;

import com.rest.api.domain.FriendDto;
import com.rest.api.mapper.FriendsMapper;
import com.rest.api.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class FriendsApplicationConfig implements CommandLineRunner {

    private final FriendRepository friendRepository;
    private final FriendsMapper friendsMapper;

    @Autowired
    public FriendsApplicationConfig(FriendRepository friendRepository, FriendsMapper friendsMapper) {
        this.friendRepository = friendRepository;
        this.friendsMapper = friendsMapper;
    }

    @PostConstruct
    public void initilizeData() {
        FriendDto data = FriendDto.builder()
                .id(1)
                .firstName("Yogesh")
                .lastName("Sharma")
                .emailId("yogesh@gogesh.com")
                .build();

        friendRepository.save(friendsMapper.toEntity(data));

        data = FriendDto.builder()
                .id(2)
                .firstName("Mohan")
                .lastName("Ganesh")
                .emailId("mohan@test.com")
                .build();


        friendRepository.save(friendsMapper.toEntity(data));


    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("initilize {} ", args);
    }
}
