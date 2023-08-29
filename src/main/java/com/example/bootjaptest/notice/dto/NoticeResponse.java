package com.example.bootjaptest.notice.dto;

import com.example.bootjaptest.notice.entity.NoticeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private long hits;
    private long likes;
    private long userId;
    private String userName;

    public static NoticeResponse form(NoticeEntity noticeEntity) {
        return NoticeResponse.builder()
                .id(noticeEntity.getId())
                .title(noticeEntity.getTitle())
                .content(noticeEntity.getContent())
                .registerDate(noticeEntity.getRegisterDate())
                .updateDate(noticeEntity.getUpdatedDate())
                .hits(noticeEntity.getHits())
                .likes(noticeEntity.getLikes())
                .userId(noticeEntity.getUserEntity().getId())
                .userName(noticeEntity.getUserEntity().getUsername())
                .build();
    }

}
