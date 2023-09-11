package com.example.bootjaptest.user.controller;

import com.example.bootjaptest.notice.repository.NoticeRepository;
import com.example.bootjaptest.user.dto.request.UserSearchRequest;
import com.example.bootjaptest.user.dto.request.UserStatusRequest;
import com.example.bootjaptest.user.dto.response.MessageResponse;
import com.example.bootjaptest.user.dto.response.UserSummary;
import com.example.bootjaptest.user.entity.UserEntity;
import com.example.bootjaptest.user.entity.UserLoginHistory;
import com.example.bootjaptest.user.repository.UserLoginHistoryRepository;
import com.example.bootjaptest.user.repository.UserRepository;
import com.example.bootjaptest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AdminUserController {

    private final UserRepository userRepository;
    private final NoticeRepository noticeRepository;
    private final UserLoginHistoryRepository userLoginHistoryRepository;

    private final UserService userService;

    // 48. 사용자 목록과 사용자 수를 함께 내리는 API
    @GetMapping("/api/admin/user")
    public MessageResponse userList() {
        List<UserEntity> userEntityList = userRepository.findAll();
        long totalUserCount = userRepository.count();

        return MessageResponse.builder()
                .body(userEntityList)
                .totalUserCount(totalUserCount)
                .build();
    }

    // 49. 사용자 상세 조회 API
    @GetMapping("/api/admin/user/{id}")
    public ResponseEntity<?> userDetail(@PathVariable Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(MessageResponse.success(userEntity));
    }

    // 50. 사용자 목록 조회에 대한 검색 API (이메일, 이름, 전화번호에 대한 검색결과 리턴)
    @GetMapping("/api/admin/user/search")
    public ResponseEntity<?> SearchUser(@RequestBody UserSearchRequest userSearchRequest) {
        List<UserEntity> searchUserList = userRepository.findByEmailContainsOrUsernameContainsOrPhoneNumberContains(
                userSearchRequest.getEmail(), userSearchRequest.getUsername(), userSearchRequest.getPhoneNumber());
        return ResponseEntity.ok().body(MessageResponse.success(searchUserList));
    }

    // 51. 사용자의 상태 변경하는 API (정상, 정지)
    @PatchMapping("/api/admin/user/{id}/status")
    public ResponseEntity<?> userStatus(@PathVariable Long id, @RequestBody UserStatusRequest userStatusRequest) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }
        UserEntity user = optionalUserEntity.get();
        user.setUserStatus(userStatusRequest.getUserStatus());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    // 52. 사용자 정보를 삭제하는 API (작성된 게시글이 있으면 예외)
    @DeleteMapping("/api/admin/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.fail("사용자 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }
        UserEntity user = optionalUserEntity.get();

        if (noticeRepository.countByUserEntity(user) > 0) {
            return new ResponseEntity<>(MessageResponse.fail("사용자가 작성한 공지사항이 있습니다."), HttpStatus.BAD_REQUEST);
        }

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    // 53. 사용자가 로그인을 했을 때 이에 대한 접속 이력이 저장된다고 했을 떄, 이에 대한 접속 이력 조회 API
    @GetMapping("/api/admin/user/login/history")
    public ResponseEntity<?> userLoginHistory() {
        List<UserLoginHistory> loginHistories = userLoginHistoryRepository.findAll();

        return ResponseEntity.ok().body(loginHistories);
    }

    // 53. 사용자의 접속을 제한하는 API
    @PatchMapping("/api/admin/user/{id}/lock")
    public ResponseEntity<?> userLock(@PathVariable Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.fail("사용자의 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = byId.get();
        if (user.isLockYn()) {
            return new ResponseEntity<>(MessageResponse.fail("접속제한이 된 사용자 입니다."), HttpStatus.BAD_REQUEST);
        }
        user.setLockYn(true);
        userRepository.save(user);
        return ResponseEntity.ok().body(MessageResponse.success());
    }

    // 55. 사용자의 접속제한을 해제하는 API
    @PatchMapping("/api/admin/user/{id}/unlock")
    public ResponseEntity<?> userUnlock(@PathVariable Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return new ResponseEntity<>(MessageResponse.fail("사용자의 정보가 존재하지 않습니다."), HttpStatus.BAD_REQUEST);
        }

        UserEntity user = byId.get();
        if (user.isLockYn()) {
            return new ResponseEntity<>(MessageResponse.fail("이미 접속제한이 해재된 사용자 입니다."), HttpStatus.BAD_REQUEST);
        }
        user.setLockYn(false);
        userRepository.save(user);
        return ResponseEntity.ok().body(MessageResponse.success());
    }

    // 56. 회원 전체수와 상태별 회원수에 대한 정보를 리턴 API
    @PatchMapping("/api/admin/user/status/count")
    public ResponseEntity<?> userStatusCount() {
        UserSummary userSummary = userService.getUserStatusCount();

        return ResponseEntity.ok().body(MessageResponse.success(userSummary));
    }

}
