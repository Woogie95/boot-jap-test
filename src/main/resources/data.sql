INSERT INTO USER_ENTITY(ID, EMAIL, PASSWORD, PHONE_NUMBER, REGISTER_DATE, UPDATE_DATE, USERNAME, USER_STATUS, LOCK_YN)
VALUES (1, 'test@naver.com', '1111', '010-1111-1111', '2023-08-29 21:17:34.779623', null, '최성욱', 1, true),
       (2, 'test1@naver.com', '2222', '010-2222-2222', '2023-08-29 21:17:34.779623', null, '박지성', 2, false),
       (3, 'test2@naver.com', '3333', '010-3333-3333', '2023-08-29 21:17:34.779623', null, '손흥민', 1, true),
       (4, 'test3@naver.com', '4444', '010-4444-4444', '2023-08-29 21:17:34.779623', null, '차범근', 2, false),
       (5, 'test5@naver.com', '5555', '010-4444-4444', '2023-08-29 21:17:34.779623', null, '메시', 1, false),
       (6, 'test6@naver.com', '5555', '010-4444-4444', '2023-09-12 21:17:34.779623', null, '호날두', 1, false),
       (7, 'test7@naver.com', '5555', '010-4444-4444', '2023-09-12 21:17:34.779623', null, '기성용', 1, false);

INSERT INTO NOTICE_ENTITY(ID, CONTENT, HITS, LIKES, REGISTER_DATE, TITLE, is_deleted, USER_ENTITY_ID)
VALUES (1, '내용1', 0, 1, '2023-08-29 21:17:34.779623', '제목1', false, 1)
     , (2, '내용2', 0, 2, '2023-08-29 21:17:34.779623', '제목2', false, 2)
     , (3, '내용3', 0, 3, '2023-08-29 21:17:34.779623', '제목3', false, 1)
     , (4, '내용3', 0, 4, '2023-08-29 21:17:34.779623', '제목3', false, 4)
     , (5, '내용3', 0, 5, '2023-08-29 21:17:34.779623', '제목3', false, 5);

INSERT INTO NOTICE_LIKE(ID, notice_entity_id, user_entity_id)
VALUES (1, 3, 1),
       (2, 4, 1),
       (3, 5, 7),
       (4, 1, 3),
       (5, 1, 4),
       (6, 1, 1);