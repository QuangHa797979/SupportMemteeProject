
DROP DATABASE IF EXISTS demomockproject;
CREATE DATABASE demomockproject;
USE demomockproject;

-- create table Mentee
DROP TABLE IF EXISTS Mentee;
CREATE TABLE Mentee	(
	mentee_id		SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name		VARCHAR(50) UNIQUE NOT NULL CHECK(length(user_name) >= 6 AND length(user_name) <=50),
    `password`		VARCHAR(800) NOT NULL,
    phone_number	CHAR(15) NOT NULL CHECK(length(phone_number) >= 9 AND length(phone_number) <=15),
    email			VARCHAR(50) UNIQUE NOT NULL CHECK(length(email) >= 6 AND length(email) <=50)
);

-- create table Request
DROP TABLE IF EXISTS Request;
CREATE TABLE Request	(
	request_id	  			SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  --   `type`					ENUM("retest","reserve", "support") NOT NULL,
  `type`					ENUM("retest","reserve", "support", "relearn") NOT NULL,
    note					TEXT,
    title					NVARCHAR(50) NOT NULL ,
    mentee_id				SMALLINT UNSIGNED NOT NULL,
    -- Nên thêm cái ngày tạo request
    FOREIGN KEY(mentee_id) REFERENCES Mentee (mentee_id)
);

-- create table Requestsupport
DROP TABLE IF EXISTS Requestsupport;
CREATE TABLE Requestsupport	(
	request_support_id		SMALLINT UNSIGNED PRIMARY KEY,
    subject_name			VARCHAR(50) NOT NULL,
    lesson_name				VARCHAR(50) NOT NULL,
    create_date				DATETIME NOT NULL,
	start_time				DATETIME DEFAULT NOW() NOT NULL,
    end_time				DATETIME NOT NULL,
	supervisor_name			VARCHAR(50) NOT NULL,
    note					VARCHAR(500),
    `status`				ENUM("send","pending","approve","refuse"),
     FOREIGN KEY(request_support_id) REFERENCES Request(request_id)
);
    -- create table Subject
CREATE TABLE `Subject`	(
	subject_id		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    subject_name	VARCHAR(50) NOT NULL UNIQUE
);

-- create table Lesson
CREATE TABLE Lesson	(
	lesson_id		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    lesson_name		VARCHAR(50) NOT NULL UNIQUE CHECK(length(lesson_name) >= 6 AND length(lesson_name) <=50),
    subject_id		SMALLINT UNSIGNED NOT NULL,
	FOREIGN KEY(subject_id) REFERENCES Subject (subject_id)
);
-- create table Request_relearn
	CREATE TABLE Request_relearn	(
	request_id		SMALLINT UNSIGNED PRIMARY KEY,
    lesson_id		SMALLINT UNSIGNED,
    start_date		DATETIME DEFAULT(now()),
    end_date		DATETIME DEFAULT(now()),
    `status`		ENUM("SEND","PENDING","APPROVE","REFUSE") NOT NULL,
	FOREIGN KEY(request_id) REFERENCES Request (request_id),
	FOREIGN KEY(lesson_id) REFERENCES Lesson (lesson_id)
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
                
-- Add data Request       
INSERT INTO Request	(  		`type`		,		note	, 	title, 	mentee_id)
VALUES 						('retest'	,'abc'		,	'abcde'	,	1	),
							('reserve'	,'abc'		,	'abcde'	,	2	),
							('support'	,'abc'		,	'abcde'	,	3	),
							('reserve'	,'abc'		,	'abcde'	,	4	),
							('reserve'	,'abc'		,	'abcde'	,	5	),
							('support'	,'abc'		,	'abcde'	,	6	),
						-- ('reserve'	,'abc'		,	'abcde'	,	7	),
                            ('relearn'	,'abc'		,	'abcde'	,	7	),
							('support'	,'abc'		,	'abcde'	,	8	),
                         -- ('reserve'	,'abc'		,	'abcde'	,	9	),
							('relearn'	,'abc'		,	'abcde'	,	9	),
							('retest'	,'abc'		,	'abcde'	,	10	);
                            
-- Add data Requestsupport        
INSERT INTO Requestsupport	(request_support_id,  subject_name	,		lesson_name		, create_date, start_time, end_time, supervisor_name, `status`)
VALUES 						(		3			,	'SQL'			,		1				,'2019-03-05',   '2019-03-05','2019-03-05','Toan'		, 'send'	),
							(		6			,	'JAVA'			,		2				,'2020-03-07',   '2020-03-07','2020-03-07','Hung'		, 'pending'),
							(		8			,	'SPRRING'		,		3				,'2020-03-09',   '2020-03-09','2020-03-09','Tuan'		, 'approve');
-- 							(					,	'VISUAL'		,		4				,'2020-03-10',   '2020-03-10','2020-03-10','Van'		, 'pending'),
-- 							(					,	'MATH'			,		5				,'2020-03-28',   '2020-03-28','2020-03-28','Tam'		, 'approve'),
-- 							(					,	'SCIENCE'		,		6				,'2020-04-06',   '2020-04-06','2020-04-06','An'		, 'refuse'),
-- 							(					,	'DATABASE'		,		7				,'2020-04-07',   '2020-04-07','2020-04-07','Nhung'	, 'refuse'),
-- 							(					,	'PHYSIC'		,		8				,'2020-04-08',   '2020-04-08','2020-04-08','Duy'		, 'pending'),
-- 							(					,	'ACCOUNT'		,		9				,'2020-04-09',   '2020-04-09','2020-04-09','Cuong'	, 'approve'),
-- 							(					,	'BANKING'		,		10				,'2020-04-10',   '2020-04-10','2020-04-10','Duc'		, 'send');

-- Add data Subject
INSERT INTO subject 	(subject_name)
value					("Java"),
						("MySQL"),
                        ("Angular");
                        
-- Add data Lesson
INSERT INTO Lesson 	(lesson_name,		subject_id)
value					("Java-core",			1),
						("Java-advance",		1),
						("MySQL căn bản",		2),
                        ("Angular-Byding data",	3);
 -- Add data request_relearn
INSERT INTO Request_relearn 	(request_id,	lesson_id,	start_date,				end_date,				status)
value							(	7,				1,		"2020/10/15 19-00-00",	"2020/11/15 22-00-00",	"SEND"),
								(	9,				2,		"2020/10/15 19-00-00",	"2020/11/15 22-00-00",	"PENDING");                             
select * from  Mentee;                    
select * from  Requestsupport; 
select * from  Request; 

    -- create table Subject
CREATE TABLE `Subject`	(
	subject_id		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    subject_name	VARCHAR(50) NOT NULL UNIQUE
);

-- create table Lesson
CREATE TABLE Lesson	(
	lesson_id		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    lesson_name		VARCHAR(50) NOT NULL UNIQUE,
    subject_id		SMALLINT UNSIGNED,
	FOREIGN KEY(subject_id) REFERENCES Subject (subject_id)
);

-- create table Request_retest
DROP TABLE IF EXISTS Request_retest;
CREATE TABLE Request_retest	(
	request_id		SMALLINT UNSIGNED PRIMARY KEY,
    subject_id		SMALLINT UNSIGNED,
--     type_retest		ENUM("MULTIPLE_CHOICE","ESSAY","INTERVIEW") NOT NULL,
    `time`			DATETIME NOT NULL,
    `point`			SMALLINT UNSIGNED,
    `status`		ENUM("SEND","EXAM_SCHEDULED","FINISH","REFUSE"),
	FOREIGN KEY(request_id) REFERENCES Request (request_id),
    FOREIGN KEY(subject_id) REFERENCES `Subject` (subject_id)
);

-- Add data Subject
INSERT INTO `subject` 	(subject_name)
value					("Java"),
						("MySQL"),
                        ("Angular");
                        
-- Add data Lesson
INSERT INTO Lesson 	(lesson_name,		subject_id)
value					("Java-core",			1),
						("Java-advance",		1),
						("MySQL căn bản",		2),
                        ("Angular-Byding data",	3);
                            
-- Add data Request_retest
INSERT INTO Request_retest		(request_id,	subject_id,				`time`,			`point`	,		`status`)		
values							('1',			'2',					'2020-12-12',	'0',			'REFUSE'),      
								('10',			'3',					'2020-12-13',	'7',			'FINISH');      -- type_retest,		
-- 'MULTIPLE_CHOICE',	
-- 'INTERVIEW',		

--                                 ('7',			'2',			'ESSAY',					'2020-12-13',	'8',			`SEND`	),
--                                 ('8',			'2',			'MULTIPLE_CHOICE',			'2020-12-14',	'0',			`SEND`	),
--                                 ('10',			'1',			'ESSAY',					'2020-12-14',	'0',			`SEND`	),
--                                 ('12',			'2',			'ESSAY',					'2020-12-15',	'5',			`SEND`	),
--                                 ('13',			'1',			'MULTIPLE_CHOICE',			'2020-12-15',	'0',			`SEND`	),
--                                 ('16',			'2',			'INTERVIEW',				'2020-12-15',	'5',			`SEND`	),
--                                 ('18',			'3',			'MULTIPLE_CHOICE',			'2020-12-15',	'0',			`SEND`	),
--                                 ('19',			'2',			'INTERVIEW',				'2020-12-16',	'0',			`SEND`	),

SELECT * FROM `subject`;
SELECT * FROM `Lesson`;
SELECT * FROM `Request_retest`;
