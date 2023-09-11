package com.example.bootjaptest.user.entity;

import com.example.bootjaptest.user.model.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String phoneNumber;
    @Column
    private LocalDateTime registerDate;
    @Column
    private LocalDateTime updateDate;

    private UserStatus userStatus;
    private boolean lockYn;

}
