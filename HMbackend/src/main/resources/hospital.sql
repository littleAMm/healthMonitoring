DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS rx;
DROP TABLE IF EXISTS docpat;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS health;
SET GLOBAL time_zone = '+8:00';

CREATE TABLE patient
(
    username     VARCHAR(20) UNIQUE,
    id           int(11) PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(20),
    sex          VARCHAR(1) DEFAULT '男',
    symptom      VARCHAR(200),
    age          NUMERIC(3),
    phone_number NUMERIC(11),
    address      VARCHAR(50),
    CHECK (sex in ('男', '女') ),
    CHECK (age > 0 AND age < 150)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 20220001;

CREATE TABLE doctor
(
    username     VARCHAR(20) UNIQUE,
    id           int(11) PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(20),
    sex          VARCHAR(1) DEFAULT '男'
        CHECK (sex in ('男', '女') ),
    age          NUMERIC(3),
    phone_number NUMERIC(11),
    address      VARCHAR(50),
    work         VARCHAR(200),
    work_time    VARCHAR(30)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 20221001;

CREATE TABLE user
(
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    role     varchar(5) DEFAULT '患者'
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

CREATE TABLE rx
(
    patient_id INT(11),
    content    VARCHAR(200),
    PRIMARY KEY (patient_id, content)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

CREATE TABLE docpat
(
    doctor_id  INT(11),
    patient_id INT(11),
    PRIMARY KEY (doctor_id, patient_id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

CREATE TABLE health
(
    patient_id  INT(11),
    table_index INT(3) UNIQUE AUTO_INCREMENT,
    tmep        DOUBLE,
    status      VARCHAR(2) DEFAULT '良好',
    pulse       DOUBLE,
    date        TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (patient_id, table_index),
    CHECK (status in ('健康', '良好', '差'))
) ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;