-- create database
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
SET GLOBAL sql_mode = 'NO_ENGINE_SUBSTITUTION';
SET SESSION sql_mode = 'NO_ENGINE_SUBSTITUTION';
DROP DATABASE IF EXISTS demomockproject;
CREATE DATABASE demomockproject;
USE demomockproject;

-- create table Mentee
DROP TABLE IF EXISTS Mentee;
CREATE TABLE Mentee	(
	mentee_id		SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name		VARCHAR(50) UNIQUE NOT NULL CHECK(length(user_name) >= 6 AND length(user_name) <=50),
    `password`		VARCHAR(800) NOT NULL,
    phone_number	CHAR(15) CHECK(length(phone_number) >= 9 AND length(phone_number) <=15 ) NOT NULL,
    email			VARCHAR(50) UNIQUE NOT NULL CHECK(length(email) >= 6 AND length(email) <=50)
);

-- create table Requestsupport
DROP TABLE IF EXISTS Requestsupport;
CREATE TABLE Requestsupport	(
	request_support_id		SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subject_name			VARCHAR(50) NOT NULL,
    lesson_name				VARCHAR(50) NOT NULL,
    create_date				DATETIME NOT NULL,
	start_time				DATETIME DEFAULT NOW() NOT NULL,
    end_time				DATETIME NOT NULL,
	supervisor_tutor_name	VARCHAR(50) NOT NULL,
	supervisor_mentor_name	VARCHAR(50) NOT NULL,
    `status`					ENUM("send","pending","approve","refuse")
);

-- create table Request
DROP TABLE IF EXISTS Request;
CREATE TABLE Request	(
	request_id	  			SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type`					ENUM("retest","reserve", "support"),
    note					TEXT,
    title					NVARCHAR(50) NOT NULL ,
    mentee_id				SMALLINT UNSIGNED NOT NULL,
	request_support_id		SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY(mentee_id) REFERENCES Mentee (mentee_id),
	FOREIGN KEY(request_support_id) REFERENCES Requestsupport (request_support_id)
);


-- Add data Mentee
INSERT INTO Mentee (user_name,			email,							`password`,   phone_number)
VALUES			('hanh.havan@vti',		'hanhhanoi1999@gmail.com',		'123456',	'123456888888')		, 
				('thanhhung12@vti',		'hung122112@gmail.com',			'123456',	'123456888888')		, 
				('can.tuananh@vti',		'cananh.tuan12@vti.com',		'123456',	'123456888888')		, 
				('toananh123@vti',		'toananh123@vti.com',			'123456',	'123456888888')		, 
				('duynn123@vti',		'duynguyen123@vti.com',			'123456',	'123456888888')		, 
				('manhhung123@vti',		'manhhung123@vti.com',			'123456',	'123456888888')		,
 				('maianhvti123',		'maianhng@gmail.com', 			'123456',	'123456888888')		,
				('tuanvti12344',		'tuan1234@gmail.com', 			'123456',	'123456888888')		,
				('ngthuy123',			'thuyhanoi@gmail.com', 			'123456',	'123456888888')		,
				('quanganhvti',			'quanganh@gmail.com', 			'123456',	'123456888888')		;
-- Add data Requestsupport        
INSERT INTO Requestsupport	(  subject_name	,		lesson_name		, create_date, start_time, end_time, supervisor_tutor_name, supervisor_mentor_name, `status`)
VALUES 						('SQL'			,		1				,'2019-03-05',   '2019-03-05','2019-03-05','Toan'	,'Toan'		, 'send'),
							('JAVA'			,		2				,'2020-03-07',   '2020-03-07','2020-03-07','Hung'	,'Hung'		, 'send'),
							('SPRRING'		,		3				,'2020-03-09',   '2020-03-09','2020-03-09','Tuan'	,'Tuan'		, 'send'),
							('VISUAL'		,		4				,'2020-03-10',   '2020-03-10','2020-03-10','Van'	,'Van'		, 'send'),
							('MATH'			,		5				,'2020-03-28',   '2020-03-28','2020-03-28','Tam'	,'Tam'		, 'send'),
							('SCIENCE'		,		6				,'2020-04-06',   '2020-04-06','2020-04-06','An'		,'An'		, 'send'),
							('DATABASE'		,		7				,'2020-04-07',   '2020-04-07','2020-04-07','Nhung'	,'Nhung'	, 'send'),
							('PHYSIC'		,		8				,'2020-04-08',   '2020-04-08','2020-04-08','Duy'	,'Duy'		, 'send'),
							('ACCOUNT'		,		9				,'2020-04-09',   '2020-04-09','2020-04-09','Cuong'	,'Cuong'	, 'send'),
							('BANKING'		,		10				,'2020-04-10',   '2020-04-10','2020-04-10','Duc'	,'Duc'		, 'send');

-- Add data Request       
INSERT INTO Request	(  `type`		,		note	, 	title, 	mentee_id, 	request_support_id	)
VALUES 						('retest'	,'abc'		,	'abcde'	,	1	,		1		),
							('reserve'	,'abc'		,	'abcde'	,	2	,		2		),
							('support'	,'abc'		,	'abcde'	,	3	,		3			),
							('reserve'	,'abc'		,	'abcde'	,	4	,		4			),
							('reserve'	,'abc'		,	'abcde'	,	5	,		5			),
							('support'	,'abc'		,	'abcde'	,	6	,		6			),
							('reserve'	,'abc'		,	'abcde'	,	7	,		7	),
							('support'	,'abc'		,	'abcde'	,	8	,		8			),
							('reserve'	,'abc'		,	'abcde'	,	9	,		9		),
							('retest'	,'abc'		,	'abcde'	,	10	,		10			);
select * from Mentee;                    
select * from  Requestsupport; 
select * from  Request; 
