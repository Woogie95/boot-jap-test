package com.example.bootjaptest.user.service;

import com.example.bootjaptest.user.dto.response.UserLogCount;
import com.example.bootjaptest.user.dto.response.UserNoticeCount;
import com.example.bootjaptest.user.dto.response.UserSummary;
import com.example.bootjaptest.user.entity.UserEntity;

import java.util.List;


public interface UserService {

    UserSummary getUserStatusCount();

    List<UserEntity> getTodayUsers();

    List<UserNoticeCount> getUserNoticeCount();

    List<UserLogCount> getUserLogCount();

    List<UserLogCount> getUserLikeBest();

}