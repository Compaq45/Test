INSERT INTO USRS (FIRST_NAME, LAST_NAME) VALUES ('admin', 'adminovich');
INSERT INTO USRS (FIRST_NAME, LAST_NAME) VALUES ('user', 'userovich');
INSERT INTO TASK (TASK_NAME, TASK_COMMENT, TASK_CREATE_TIMESTAMP) VALUES ('task1', 'Comment1', '2022-12-31 23.59.59');
INSERT INTO TASK (TASK_NAME, TASK_COMMENT, TASK_CREATE_TIMESTAMP) VALUES ('task2', 'Comment2', '2022-12-31 23.59.59');
INSERT INTO MESSAGES (MESSAGE_TEXT,MESSAGE_CREATE_TIMESTAMP,TASK_ID,USER_ID) VALUES ( 'Message1', '2021-12-31 08.59.59',1, 2 );
INSERT INTO MESSAGES (MESSAGE_TEXT,MESSAGE_CREATE_TIMESTAMP,TASK_ID,USER_ID) VALUES ( 'Message2', '2021-12-31 08.59.59',1, 2 );
INSERT INTO MESSAGES (MESSAGE_TEXT,MESSAGE_CREATE_TIMESTAMP,TASK_ID,USER_ID) VALUES ( 'Message3', '2021-12-31 08.59.59',2, 1 );
INSERT INTO MESSAGES (MESSAGE_TEXT,MESSAGE_CREATE_TIMESTAMP,TASK_ID,USER_ID) VALUES ( 'Message4', '2021-12-31 08.59.59',2, 1 );