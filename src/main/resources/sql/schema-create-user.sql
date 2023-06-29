use data_jdbc;

CREATE TABLE user
(
    `id`      INT            NOT NULL    AUTO_INCREMENT COMMENT '회원id',
    `name`    VARCHAR(45)    NULL        COMMENT '이름',
    `email`   VARCHAR(45)    NULL        COMMENT '메일',
    `gender`  INT            NULL        COMMENT '성별',
    PRIMARY KEY (id)
);