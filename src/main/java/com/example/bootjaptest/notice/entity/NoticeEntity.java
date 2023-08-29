package com.example.bootjaptest.notice.entity;

import com.example.bootjaptest.user.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime registerDate;
    private LocalDateTime updatedDate;
    private long hits;
    private long likes;
    private boolean isDeleted;
    private LocalDateTime deletedDate;
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

}
