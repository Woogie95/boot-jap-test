package com.example.bootjaptest.user.service.impl;

import com.example.bootjaptest.user.dto.response.UserLogCount;
import com.example.bootjaptest.user.dto.response.UserNoticeCount;
import com.example.bootjaptest.user.dto.response.UserSummary;
import com.example.bootjaptest.user.entity.UserEntity;
import com.example.bootjaptest.user.model.UserStatus;
import com.example.bootjaptest.user.repository.UserCustomRepository;
import com.example.bootjaptest.user.repository.UserRepository;
import com.example.bootjaptest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCustomRepository userCustomRepository;

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

    @Override
    public List<UserEntity> getTodayUsers() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime startDate = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 0, 0);
        LocalDateTime endDate = startDate.plusDays(1);
        return userRepository.findToday(startDate, endDate);
    }

    @Override
    public List<UserNoticeCount> getUserNoticeCount() {
        return userCustomRepository.findUserNoticeCount();
    }

    @Override
    public List<UserLogCount> getUserLogCount() {
        return userCustomRepository.findUserLogCount();
    }

    @Override
    public List<UserLogCount> getUserLikeBest() {
        return userCustomRepository.findUserLikeBest();

    }

}
