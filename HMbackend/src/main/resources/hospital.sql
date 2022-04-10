DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS rx;
DROP TABLE IF EXISTS docpat;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS health;
DROP TABLE IF EXISTS worktime;

CREATE TABLE patient(
                        username VARCHAR(20) UNIQUE,
                        id NUMERIC(11) PRIMARY KEY,
                        name VARCHAR(20),
                        sex VARCHAR(1) DEFAULT '男'
                            CHECK(sex in ('男','女') )
)ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE doctor(
                       username VARCHAR(20) UNIQUE,
                       id NUMERIC(11) PRIMARY KEY,
                       name VARCHAR(20),
                       sex VARCHAR(1) DEFAULT '男'
                           CHECK(sex in ('男','女') ),
                       work VARCHAR(200)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE user(
                     username VARCHAR(20) NOT NULL UNIQUE,
                     password VARCHAR(20) NOT NULL,
                     role varchar(5) DEFAULT '患者'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE rx(
                   patient_id INT(11),
                   content VARCHAR(200),
                   PRIMARY KEY(patient_id,content)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE docpat(
                       doctor_id INT(11),
                       patient_id INT(11),
                       PRIMARY KEY(doctor_id,patient_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE health(
                       patient_id INT(11) PRIMARY KEY,
                       tmep DOUBLE,
                       status VARCHAR(2) DEFAULT '良好'
                           CHECK(status in ('健康','良好','差'))
)ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE worktime(
                         doctor_id INT(11) PRIMARY KEY,
                         start_time TIMESTAMP,
                         end_time TIMESTAMP
)ENGINE=INNODB DEFAULT CHARSET=utf8;
