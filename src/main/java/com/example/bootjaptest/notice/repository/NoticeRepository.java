package com.example.bootjaptest.notice.repository;

import com.example.bootjaptest.notice.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {

}
