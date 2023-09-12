package com.example.bootjaptest.user.repository;

import com.example.bootjaptest.user.dto.response.UserLogCount;
import com.example.bootjaptest.user.dto.response.UserNoticeCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserCustomRepository {

    private final EntityManager entityManager;

    public List<UserNoticeCount> findUserNoticeCount() {
        String sql =
                " select u.id, u.email, u.username, (select count(*) from notice_entity n where n.user_entity_id = u.id) notice_count from user_entity u";

        return (List<UserNoticeCount>) entityManager.createNativeQuery(sql).getResultList();
    }

    public List<UserLogCount> findUserLogCount() {
        String sql =
                " select u.id, u.email, u.username, " +
                        "(select count(*) from notice_entity n where n.user_entity_id = u.id) as notice_count, " +
                        "(select count(*) from notice_like nl where nl.user_entity_id = u.id) as notice_like_count " +
                        " from user_entity u";
        return (List<UserLogCount>) entityManager.createNativeQuery(sql).getResultList();
    }

    public List<UserLogCount> findUserLikeBest() {
        String sql =
                " select t1.id, t1.email, t1.username, t1.notice_like_count" +
                        " from (" +
                        " select u.*, (select count(*) from notice_like nl where nl.user_entity_id = u.id) as notice_like_count" +
                        " from user_entity u" +
                        ") t1 " +
                        "order by t1.notice_like_count desc;";
        return (List<UserLogCount>) entityManager.createNativeQuery(sql).getResultList();
    }
}
