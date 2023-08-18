package com.example.bootjaptest.notice.controller;

import com.example.bootjaptest.notice.entity.NoticeEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NoticeController {

    @GetMapping("/api/notice")
    public String showNotice() {
        return "공지사항 입니다.";
    }

    @GetMapping("/api/notice-2")
    public NoticeEntity showNoticeModel() {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setId(1L);
        noticeEntity.setTitle("제목입니다.");
        noticeEntity.setContent("내용입니다.");
        noticeEntity.setRegistered(LocalDateTime.now());

        return noticeEntity;
    }

    @GetMapping("/api/notice-3")
    public List<NoticeEntity> showNoticeModels() {
        List<NoticeEntity> noticeEntities = new ArrayList<>();

        noticeEntities.add(NoticeEntity.builder()
                .id(1L)
                .title("제목1")
                .content("내용1")
                .registered(LocalDateTime.now())
                .build());
        noticeEntities.add(NoticeEntity.builder()
                .id(2L)
                .title("제목2")
                .content("내용2")
                .registered(LocalDateTime.now())
                .build());
        return noticeEntities;
    }

    @GetMapping("/api/notice-4")
    public List<NoticeEntity> showNoticeModels2() {
        return new ArrayList<>();
    }

    @GetMapping("/api/notice/count")
    public Long showNoticeTotalSize() {
        return 20L;
    }

    @PostMapping("/api/notice")
    public NoticeEntity addNotice(String title, String content) {

        return NoticeEntity.builder()
                .id(1L)
                .title(title)
                .content(content)
                .registered(LocalDateTime.now())
                .build();
    }

    @PostMapping("/api/notice_2")
    public NoticeEntity addNotice(NoticeEntity noticeEntity) {
        noticeEntity.setId(3L);
        noticeEntity.setRegistered(LocalDateTime.now());
        return noticeEntity;
    }
}
