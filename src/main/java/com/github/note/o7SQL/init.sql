-- 创建class 表
create table classes
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- 创建students表
create table students
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    class_id BIGINT       NOT NULL,
    name     VARCHAR(100) NOT NULL,
    gender   VARCHAR(1)   NOT NULL,
    score    INT          NOT NULL,
    PRIMARY KEY (id)
);

-- 插入classes记录
INSERT INTO classes(id, name)
VALUES (1, '一班');
INSERT INTO classes(id, name)
VALUES (2, '二班');
INSERT INTO classes(id, name)
VALUES (3, '三班');
INSERT INTO classes(id, name)
VALUES (4, '四班');

-- 插入students记录
INSERT INTO students (id, class_id, name, gender, score)
VALUES (1, 1, '小明', 'M', 90);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (2, 1, '小红', 'F', 95);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (3, 1, '小军', 'M', 88);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (4, 1, '小米', 'F', 73);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (5, 2, '小白', 'F', 81);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (6, 2, '小兵', 'M', 55);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (7, 2, '小林', 'M', 85);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (8, 3, '小新', 'F', 91);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (9, 3, '小王', 'M', 89);
INSERT INTO students (id, class_id, name, gender, score)
VALUES (10, 3, '小丽', 'F', 85);


