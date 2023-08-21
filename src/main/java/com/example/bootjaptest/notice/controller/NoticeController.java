package com.example.bootjaptest.notice.controller;

import com.example.bootjaptest.notice.dto.CreateNoticeRequest;
import com.example.bootjaptest.notice.dto.UpdateNoticeRequest;
import com.example.bootjaptest.notice.entity.NoticeEntity;
import com.example.bootjaptest.notice.exception.NoticeNotFoundException;
import com.example.bootjaptest.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

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

    @PostMapping("/api/notice_1")
    public NoticeEntity addNotice(NoticeEntity noticeEntity) {
        noticeEntity.setId(3L);
        noticeEntity.setRegistered(LocalDateTime.now());
        return noticeEntity;
    }

    @PostMapping("/api/notice_2")
    public NoticeEntity addNotice2(@RequestBody NoticeEntity noticeEntity) {
        noticeEntity.setId(3L);
        noticeEntity.setRegistered(LocalDateTime.now());
        return noticeEntity;
    }

    @PostMapping("/api/notice_4")
    public NoticeEntity addNotice4(@RequestBody CreateNoticeRequest createNoticeRequest) {
        NoticeEntity noticeEntity = NoticeEntity.builder()
                .title(createNoticeRequest.getTitle())
                .content(createNoticeRequest.getContent())
                .registered(LocalDateTime.now())
                .build();
        noticeRepository.save(noticeEntity);
        return noticeEntity;
    }

    @PostMapping("/api/notice_5")
    public NoticeEntity addNotice5(@RequestBody CreateNoticeRequest createNoticeRequest) {
        NoticeEntity noticeEntity = NoticeEntity.builder()
                .title(createNoticeRequest.getTitle())
                .content(createNoticeRequest.getContent())
                .registered(LocalDateTime.now())
                .hits(0)
                .likes(0)
                .build();
        return noticeRepository.save(noticeEntity);
    }

    @GetMapping("/api/notice/{id}")
    public NoticeEntity getNoticeById(@PathVariable Long id) {

        Optional<NoticeEntity> byId = noticeRepository.findById(id);
        return byId.orElse(null);
    }

    @PutMapping("/api/notice/{id}")
    public void updateNotice(@PathVariable Long id, @RequestBody UpdateNoticeRequest updateNoticeRequest) {
       /* 기본적인 코드
        Optional<NoticeEntity> noticeRepositoryById = noticeRepository.findById(id);

        if (noticeRepositoryById.isEmpty()) {
            throw new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다.");
        }
        */

        // 람다활용
        NoticeEntity notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));
        notice.setTitle(updateNoticeRequest.getTitle());
        notice.setContent(updateNoticeRequest.getContent());
        notice.setUpdated(LocalDateTime.now());
        noticeRepository.save(notice);

    }
}