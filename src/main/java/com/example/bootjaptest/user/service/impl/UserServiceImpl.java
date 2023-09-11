package com.example.bootjaptest.user.service.impl;

import com.example.bootjaptest.user.dto.response.UserSummary;
import com.example.bootjaptest.user.model.UserStatus;
import com.example.bootjaptest.user.repository.UserRepository;
import com.example.bootjaptest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserSummary getUserStatusCount() {
        long usingUserCount = userRepository.countByUserStatus(UserStatus.USING);
        long stopUserCount = userRepository.countByUserStatus(UserStatus.STOP);
        long totalCount = userRepository.count();

        return UserSummary.builder()
                .usingUserCount(usingUserCount)
                .stopUserCount(stopUserCount)
                .totalUserCount(totalCount)
                .build();
    }
}
