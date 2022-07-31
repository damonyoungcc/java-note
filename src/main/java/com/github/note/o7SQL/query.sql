-- 查询一张表的所有记录
SELECT * FROM CLASSES;
SELECT * FROM STUDENTS;

-- 条件查询
-- 查询学生中分数在80以上的学生
SELECT * FROM STUDENTS WHERE SCORE >= 80;
-- 多个条件查询 取交集用AND
SELECT * FROM STUDENTS WHERE SCORE >= 80 AND GENDER = 'M';
-- 多个条件查询 取并集用OR
SELECT * FROM STUDENTS WHERE SCORE >= 80 OR GENDER = 'M';
-- NOT 表示不符合该条件
SELECT * FROM STUDENTS WHERE NOT CLASS_ID = 2;
-- 组合多个条件查询语句，需要用小括号()表示如何进行条件计算，分数在80以下或者90以上，并且是男生
SELECT * FROM STUDENTS WHERE (SCORE < 80 OR SCORE > 90) AND GENDER = 'M';


-- 投影查询
-- 只展示某几列
SELECT ID, SCORE, NAME FROM STUDENTS;
-- 还可以给每一列起一个别名
SELECT ID, SCORE POINTS, NAME FROM STUDENTS;
-- 投影接WHERE 条件
SELECT ID, SCORE POINTS, NAME FROM STUDENTS WHERE GENDER = 'M';


-- 排序
-- 按分数排序
SELECT ID, SCORE, NAME FROM STUDENTS ORDER BY SCORE;
-- 倒排序 加上 DESC
SELECT ID, GENDER, NAME, SCORE FROM STUDENTS ORDER BY SCORE DESC;
-- 先按score列排序，如果有相同分数，再按gender排序
SELECT ID, GENDER, NAME, SCORE FROM STUDENTS ORDER BY SCORE DESC, GENDER;
-- 如果有WHERE子句，那么ORDER_BY子句要放到WHERE子句后面
SELECT ID, GENDER, NAME, SCORE FROM STUDENTS WHERE CLASS_ID = 1 ORDER BY SCORE DESC;
-- 分页，LIMIT 3 OFFSET 0 表示，对结果集从0号记录开始，最多取3条，注意索引是从0开始
SELECT ID, GENDER, NAME, SCORE FROM STUDENTS ORDER BY SCORE DESC LIMIT 3 OFFSET 0;
-- 查第2页，只需要跳过开始3条记录，结果集从3号记录开始查询，OFFSET 设定为 3
SELECT ID, GENDER, NAME, SCORE FROM STUDENTS ORDER BY SCORE DESC LIMIT 3 OFFSET 3;


-- 聚合查询
-- COUNT(*)表示查询所有列的行数 num为设置的别名
SELECT COUNT(*) num FROM STUDENTS;
-- 加 WHERE
SELECT COUNT(*) boys FROM STUDENTS WHERE gender = 'M'
-- 聚合查询计算男生平均成绩
SELECT AVG(SCORE) average FROM STUDENTS WHERE GENDER = 'M';
-- 分组
SELECT COUNT(*) num FROM STUDENTS GROUP BY CLASS_ID;
-- 分组并把class_id列也放入结果集中
SELECT CLASS_ID, COUNT(*) num FROM STUDENTS GROUP BY CLASS_ID;


-- 链接查询
-- 选出students表所有学生信息
SELECT s.id, s.name, s.class_id, s.gender, s.score FROM STUDENTS s;
-- class_id 缺少对应班级的name列
SELECT s.id, s.name, s.class_id, c.name class_name, s.gender, s.score FROM STUDENTS s INNER JOIN CLASSES C on s
                                                                                                                  .CLASS_ID = C.ID;

