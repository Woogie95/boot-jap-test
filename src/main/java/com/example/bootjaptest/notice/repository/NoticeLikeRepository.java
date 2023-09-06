package com.example.bootjaptest.notice.repository;

import com.example.bootjaptest.notice.entity.NoticeLike;
import com.example.bootjaptest.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeLikeRepository extends JpaRepository<NoticeLike, Long> {

    List<NoticeLike> findByUserEntity(UserEntity userEntity);
}
