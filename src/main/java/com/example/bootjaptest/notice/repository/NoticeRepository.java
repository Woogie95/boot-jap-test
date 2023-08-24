package com.example.bootjaptest.notice.repository;

import com.example.bootjaptest.notice.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    Optional<List<NoticeEntity>> findByIdIn(List<Long> idList);
}
