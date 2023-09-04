package com.example.bootjaptest.user.controller;

import com.example.bootjaptest.common.ErrorResponse;
import com.example.bootjaptest.notice.dto.NoticeResponse;
import com.example.bootjaptest.notice.entity.NoticeEntity;
import com.example.bootjaptest.notice.repository.NoticeRepository;
import com.example.bootjaptest.user.dto.CreateUserRequest;
import com.example.bootjaptest.user.dto.UpdateUserPasswordRequest;
import com.example.bootjaptest.user.dto.UpdateUserRequest;
import com.example.bootjaptest.user.dto.UserResponse;
import com.example.bootjaptest.user.entity.UserEntity;
import com.example.bootjaptest.user.exception.ExistEmailException;
import com.example.bootjaptest.user.exception.PasswordNotMatchException;
import com.example.bootjaptest.user.exception.UserNotFoundException;
import com.example.bootjaptest.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final NoticeRepository noticeRepository;

    @PostMapping("/api/user")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest, Errors errors) {
        List<ErrorResponse> errorResponses = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(
                    (e) -> errorResponses.add(ErrorResponse.of((FieldError) e)));
            return new ResponseEntity<>(errorResponses, HttpStatus.BAD_REQUEST);
        }
        userRepository.save(UserEntity.builder()
                .email(createUserRequest.getEmail())
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .registerDate(LocalDateTime.now())
                .build());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserRequest updateUserRequest,
                                        Errors errors) {
        List<ErrorResponse> errorResponses = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(
                    (e) -> errorResponses.add(ErrorResponse.of((FieldError) e)));
            return new ResponseEntity<>(errorResponses, HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("수정할 사용자 정보가 없습니다."));
        userEntity.setPhoneNumber(updateUserRequest.getPhoneNumber());
        userEntity.setUpdateDate(LocalDateTime.now());
        userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/user/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
        return UserResponse.from(userEntity);
    }

    /*
      내가 작성한 공지사항 목록에 대한 API 를 작성해라
      삭제일과 삭제자 아이디는 보안상 내리지 않음
      작성자 정보를 모두 내리지 않고, 작성자의 아이디와 이름만 내림
     */
    @GetMapping("/api/user/{id}/notice")
    public List<NoticeResponse> getUserNotice(@PathVariable Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

        List<NoticeEntity> noticeEntities = noticeRepository.findByUserEntity(userEntity);
        List<NoticeResponse> noticeResponseList = new ArrayList<>();

        noticeEntities.forEach((e) -> noticeResponseList.add(NoticeResponse.form(e)));

        return noticeResponseList;
    }

    // 동일한 이메일 일 경우 예외 발생 API
    @PostMapping("/api/user-1")
    public ResponseEntity<?> createUser1(@RequestBody @Valid CreateUserRequest createUserRequest, Errors errors) {
        List<ErrorResponse> errorResponseList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                errorResponseList.add(ErrorResponse.of((FieldError) e));
            });
            return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
        }
        if (userRepository.countByEmail(createUserRequest.getEmail()) > 0) {
            throw new ExistEmailException("이미 존재하는 이메일 입니다.");
        }

        UserEntity userEntity = UserEntity.builder()
                .email(createUserRequest.getEmail())
                .username(createUserRequest.getUsername())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .password(createUserRequest.getPassword())
                .registerDate(LocalDateTime.now())
                .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok().build();
    }

    // 이전 비밀번호와 일치하는 경우 수정, 그렇지 않으면 예외 발생 API
    @PatchMapping("/api/user/{id}/password")
    public ResponseEntity<?> updateUserPassword(@PathVariable Long id, @RequestBody @Valid UpdateUserPasswordRequest
            updateUserPasswordRequest, Errors errors) {

        List<ErrorResponse> errorResponseList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                errorResponseList.add(ErrorResponse.of((FieldError) e));
            });
            return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = userRepository.findByIdAndPassword(id, updateUserPasswordRequest.getPassword())
                .orElseThrow(() -> new PasswordNotMatchException("패스워드가 일치하지 않습니다."));
        userEntity.setPassword(updateUserPasswordRequest.getNewPassword());
        userRepository.save(userEntity);
        return ResponseEntity.ok().build();
    }

    // 패스워드 암호와 API
    @PostMapping("/api/user-2")
    public ResponseEntity<?> createUser2(@RequestBody @Valid CreateUserRequest createUserRequest, Errors errors) {
        List<ErrorResponse> errorResponseList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                errorResponseList.add(ErrorResponse.of((FieldError) e));
            });
            return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
        }
        if (userRepository.countByEmail(createUserRequest.getEmail()) > 0) {
            throw new ExistEmailException("이미 존재하는 이메일 입니다.");
        }

        String encrypt = getEncryptPassword(createUserRequest.getPassword());
        UserEntity userEntity = UserEntity.builder()
                .email(createUserRequest.getEmail())
                .username(createUserRequest.getUsername())
                .phoneNumber(createUserRequest.getPhoneNumber())
                .password(encrypt)
                .registerDate(LocalDateTime.now())
                .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok().build();
    }

    public String getEncryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}