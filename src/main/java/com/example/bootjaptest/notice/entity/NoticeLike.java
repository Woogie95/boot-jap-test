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
public class NoticeLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private NoticeEntity noticeEntity;

    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

}
