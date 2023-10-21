-- DROP DATABASE articledb;

CREATE DATABASE IF NOT EXISTS articledb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE articledb;

CREATE TABLE IF NOT EXISTS users 
(
	uId varchar(45) not null,
    username nvarchar(60) not null,
    uEmail varchar(60) not null,
    uPassword varchar(64) not null,
    
    primary key(uId)
);

CREATE TABLE IF NOT EXISTS articles
(
	article_id varchar(45) not null,
    title nvarchar(255) not null,
    description nvarchar(255),
    content nvarchar(1000),
	author_name varchar(60),
    time_created datetime,
    image longblob, 
    
    primary key(article_id)
);

-- default data

INSERT INTO users (uId, username, uEmail, uPassword) 
VALUES 
	('U1', N'Admin', 'admin@gmail.com', '1oe5r4CSU0CCE5Hfcc0E68vmIIuysaqJS8FcWcUnqK8=');



