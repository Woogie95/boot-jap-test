INSERT INTO USER_ENTITY(ID, EMAIL, PASSWORD, PHONE_NUMBER, REGISTER_DATE, UPDATE_DATE, USERNAME)
VALUES (1, 'test@naver.com', '1111', '010-1111-1111', '2023-08-29 21:17:34.779623', null, '최성욱');
INSERT INTO USER_ENTITY(ID, EMAIL, PASSWORD, PHONE_NUMBER, REGISTER_DATE, UPDATE_DATE, USERNAME)
VALUES (2, 'test1@naver.com', '2222', '010-2222-2222', '2023-08-29 21:17:34.779623', null, '박지성');
INSERT INTO USER_ENTITY(ID, EMAIL, PASSWORD, PHONE_NUMBER, REGISTER_DATE, UPDATE_DATE, USERNAME)
VALUES (3, 'test2@naver.com', '3333', '010-3333-3333', '2023-08-29 21:17:34.779623', null, '손흥민');
INSERT INTO USER_ENTITY(ID, EMAIL, PASSWORD, PHONE_NUMBER, REGISTER_DATE, UPDATE_DATE, USERNAME)
VALUES (4, 'test3@naver.com', '4444', '010-4444-4444', '2023-08-29 21:17:34.779623', null, '차범근');
INSERT INTO USER_ENTITY(ID, EMAIL, PASSWORD, PHONE_NUMBER, REGISTER_DATE, UPDATE_DATE, USERNAME)
VALUES (5, 'test5@naver.com', '5555', '010-4444-4444', '2023-08-29 21:17:34.779623', null, '메시');

INSERT INTO NOTICE_ENTITY(ID, CONTENT, HITS, LIKES, REGISTER_DATE, TITLE, is_deleted, USER_ENTITY_ID)
VALUES (1, '내용1', 0, 0, '2023-08-29 21:17:34.779623', '제목1', false, 1);
INSERT INTO NOTICE_ENTITY(ID, CONTENT, HITS, LIKES, REGISTER_DATE, TITLE, is_deleted, USER_ENTITY_ID)
VALUES (2, '내용2', 0, 0, '2023-08-29 21:17:34.779623', '제목2', false, 2);
INSERT INTO NOTICE_ENTITY(ID, CONTENT, HITS, LIKES, REGISTER_DATE, TITLE, is_deleted, USER_ENTITY_ID)
VALUES (3, '내용3', 0, 0, '2023-08-29 21:17:34.779623', '제목3', false, 1);
INSERT INTO NOTICE_ENTITY(ID, CONTENT, HITS, LIKES, REGISTER_DATE, TITLE, is_deleted, USER_ENTITY_ID)
VALUES (4, '내용3', 0, 0, '2023-08-29 21:17:34.779623', '제목3', false, 4);
INSERT INTO NOTICE_ENTITY(ID, CONTENT, HITS, LIKES, REGISTER_DATE, TITLE, is_deleted, user_entity_id)
VALUES (5, '내용3', 0, 0, '2023-08-29 21:17:34.779623', '제목3', false, null);

INSERT INTO NOTICE_LIKE(ID, notice_entity_id, user_entity_id)
VALUES (1, 3, 1);
INSERT INTO NOTICE_LIKE(ID, notice_entity_id, user_entity_id)
VALUES (2, 4, 1);