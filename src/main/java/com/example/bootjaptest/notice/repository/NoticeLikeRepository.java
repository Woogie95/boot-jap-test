package com.example.bootjaptest.notice.repository;

import com.example.bootjaptest.notice.entity.NoticeLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeLikeRepository extends JpaRepository<NoticeLike, Long> {

}
