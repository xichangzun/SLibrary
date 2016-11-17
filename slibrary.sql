CREATE DATABASE slibrary DEFAULT CHARACTER SET utf8;

USE slibrary;

CREATE TABLE USER(
    id VARCHAR(14) NOT NULL, 
    user_name VARCHAR(25) NOT NULL,
    pwd VARCHAR(20) NOT NULL,
    unit VARCHAR(30) NOT NULL,
    email VARCHAR(25),
    tel VARCHAR(15),
    PRIMARY KEY(id)
);

CREATE TABLE ADMIN(
	id VARCHAR(14) NOT NULL, 
    user_name VARCHAR(25),
    pwd VARCHAR(20) NOT NULL,
    unit VARCHAR(30),
    PRIMARY KEY(id)
);


CREATE TABLE BOOK(
	id VARCHAR(20) NOT NULL,
    ISBN VARCHAR(15) NOT NULL,
	book_name VARCHAR(40) NOT NULL,
    lang VARCHAR(10) NOT NULL,
    author VARCHAR(40) NOT NULL,
    press VARCHAR(40) NOT NULL,
    pub_year YEAR NOT NULL,
    call_no VARCHAR(20) NOT NULL,
    state VARCHAR(15) NOT NULL DEFAULT 'Available',
    pages SMALLINT UNSIGNED,
    size TINYINT UNSIGNED,
    cover VARCHAR(40) DEFAULT 'pictures/default.jpg',
    PRIMARY KEY(id)
);


CREATE TABLE BORROW_HISTORY(
	user_id VARCHAR(14),
    book_id VARCHAR(20),
    due_date DATE NOT NULL,
    return_date DATE,
    PRIMARY KEY(user_id, book_id, due_date),
    FOREIGN KEY(user_id) REFERENCES USER(id),
    FOREIGN KEY(book_id) REFERENCES BOOK(id)
);


CREATE TABLE RECOMMENDATION(
	user_id VARCHAR(14),
    book_name VARCHAR(40) NOT NULL,
    lang VARCHAR(10) NOT NULL,
    author VARCHAR(40) NOT NULL,
    press VARCHAR(40) NOT NULL,
    ISBN VARCHAR(15),
    price FLOAT(7,2),
    amount TINYINT UNSIGNED,
    reason VARCHAR(50) NOT NULL,
    state VARCHAR(15),
    PRIMARY KEY(user_id, ISBN),
    FOREIGN KEY(user_id) REFERENCES USER(id)
);

CREATE TABLE NEWS(
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(40),
    summary VARCHAR(100),
    content VARCHAR(500),
    add_time DATE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE RESERVATION(
	user_id VARCHAR(14),
    book_id VARCHAR(20),
    res_date DATE NOT NULL,
    state VARCHAR(15),
    PRIMARY KEY(user_id, book_id),
    FOREIGN KEY(user_id) REFERENCES USER(id),
    FOREIGN KEY(book_id) REFERENCES BOOK(id)
);

CREATE TABLE EBOOK(
	ebook_name VARCHAR(40) NOT NULL,
    author VARCHAR(40) NOT NULL,
    ISBN VARCHAR(15) NOT NULL,
    lang VARCHAR(10),
    press VARCHAR(40) NOT NULL,
    pub_year YEAR NOT NULL,
    pages SMALLINT UNSIGNED,
    cover VARCHAR(40) DEFAULT 'pictures/e_default.jpg',
    pdf VARCHAR(40) NOT NULL,
    PRIMARY KEY(ISBN)
);

CREATE TABLE UPRECORD(
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(10) NOT NULL,
  title VARCHAR(40) NOT NULL ,
  add_time DATE NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE FINE(
  user_id VARCHAR(14) NOT NULL ,
  payday DATE NOT NULL ,
  PRIMARY KEY (user_id)
);

DELIMITER $
CREATE TRIGGER addEBOOK
AFTER INSERT ON EBOOK
FOR EACH ROW
	BEGIN
		INSERT into UPRECORD (type, title, add_time)VALUE ('EBOOK',new.ebook_name,sysdate());
	END$
DELIMITER ;


#ADMIN data
INSERT INTO slibrary.admin (id, user_name, pwd, unit) VALUES ('13130130235', '杨皓庆', '123456', '301');
INSERT INTO slibrary.admin (id, user_name, pwd, unit) VALUES ('13130130253', '奚昶尊', '123456', '301');

#BOOK data
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97871115095161', 'Android和PHP开发最佳实践', '9787111509516', 'CN', '黄隽实', '机械工业出版社', 2015, 'TN929.53/463=2', 511, 25, 'pictures/9787111509516.png');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97871212801081', '操作系统原理与Linux实践教程', '9787121280108', 'CN', '申丰山, 王黎明', '电子工业出版社', 2016, 'TP316/259', 235, 26, 'pictures/9787121280108.jpg');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97871212804811', 'Red Hat Enterprise Linux 7服务器构建快学通', '9787121280481', 'CN', '曹江华', '电子工业出版社', 2016, 'TP316.85/247', 347, 26, 'pictures/9787121280481.jpg');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97812840592741', 'Wireless and mobile device security', '9781284059274', 'EN', 'Jim Doherty', 'Bartlett Learning', 2016, 'TK5105.78.D64', 392, 24, 'pictures/9781284059274.jpg');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97836596885221', 'Software security quantification', '9783659688522', 'EN', 'Chandra, Shalini.', ' LAMBERT Publishing', 2015, 'TP393.08/C456', 170, 22, 'pictures/9783659688522.jpg');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97871151722591', 'Embedded Linux', '9787115172259', 'EN', 'Hallinan,Christopher', 'The People''s Posts', 2008, 'TP316.89/H189', 537, 25, 'pictures/9787115172259.jpg');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97873012617501', 'A history of philosophy', '9787301261750', 'EN', 'Thilly, Frank', 'Peking University', 2015, 'B5/T441', 612, 23, 'pictures/9787301261750.jpg');
INSERT INTO slibrary.book (id, book_name, ISBN, lang, author, press, pub_year, call_no, pages, size, cover) VALUES ('97875641460161', 'Linux system programming', '9787564146016', 'EN', 'Robert', 'Southeast University', 2014, 'TP316.89/L897', 429, 24, 'pictures/9787564146016.jpg');




CREATE EVENT event_delnull
  ON SCHEDULE
    EVERY 1440 MINUTE STARTS '2016-01-01 00:00:00' ENDS '2016-12-31 00:00:00'
DO
  DELETE FROM RESERVATION WHERE TIMEDIFF(SYSDATE(),res_date)>'960:00:00';