CREATE DATABASE  IF NOT EXISTS `dashboard-la-management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dashboard-la-management`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: dashboard-la-management
-- ------------------------------------------------------
-- Server version	5.1.38-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `answer` text CHARACTER SET utf8 NOT NULL,
  `answer_by` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `deleted_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fk_questions_idx` (`question_id`),
  KEY `fk_users_idx` (`answer_by`),
  CONSTRAINT `fk_user_id_1` FOREIGN KEY (`answer_by`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,3,'Ahaha',6,NULL,NULL,NULL,'\0'),(2,2,'Chưa nhé',7,NULL,NULL,NULL,'\0'),(3,1,'Chống Sql injection',4,NULL,NULL,NULL,'\0');
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `img_link` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `deleted_flag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ARTICLE_FK_USER_idx` (`author_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,4,'Hỏi đáp','Tại sao bạn lại tham gia khóa đào tạo LA',NULL,'2017-09-21 00:00:00',NULL,NULL),(2,5,'Help','Thế nào là biến Static',NULL,'2017-09-21 00:00:00',NULL,NULL),(3,6,'Help','False bài Cờ cảo rồi thì làm sao??',NULL,'2017-05-21 00:00:00',NULL,NULL),(4,7,'Tìm người thân','Bạn nữ xinh xinh ngồi bàn đầu tên là gì??',NULL,'2017-07-22 00:00:00',NULL,NULL),(5,8,'Thắc mắc','Tại sao mình lại đẹp trai thế này ahihi',NULL,'2017-03-26 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `content` text CHARACTER SET utf8 NOT NULL,
  `comment_by` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `comment_by` (`comment_by`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`comment_by`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'ahihi',4,'2017-09-21 00:00:00',NULL,''),(2,3,'Good',6,'2017-09-22 00:00:00',NULL,'\0'),(3,4,'Đây là đâu?  Tôi là ai',5,'2017-09-22 00:00:00',NULL,'\0'),(4,2,'Ahihi đồ\'s ngốc\'s',9,'2017-09-22 00:00:00',NULL,'\0');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (16,'La-16','2017-02-21','2017-08-05'),(17,'La-17','2017-04-14','2017-09-04'),(18,'La-18','2017-06-14','2017-11-21');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_detail`
--

DROP TABLE IF EXISTS `emp_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_detail` (
  `emp_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  KEY `academy_detail_FK_users_idx` (`emp_id`),
  CONSTRAINT `emp_detail_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_detail`
--

LOCK TABLES `emp_detail` WRITE;
/*!40000 ALTER TABLE `emp_detail` DISABLE KEYS */;
INSERT INTO `emp_detail` VALUES (6,'Nguyễn Văn Xí','xinv@gmail.com','1234567'),(5,'Vũ Thị Nở','novt@gmail.com','1234567'),(4,'Phèo Văn Chí','chipv@gmail.com','1234567');
/*!40000 ALTER TABLE `emp_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `log_time` datetime NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_log_by_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks` (
  `student_id` int(11) NOT NULL,
  `subject_id` varchar(20) NOT NULL,
  `mark` decimal(8,1) DEFAULT NULL,
  `exam_date` datetime DEFAULT NULL,
  `note` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `deleted_flag` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`student_id`,`subject_id`),
  KEY `marks_ibfk_2_idx` (`subject_id`),
  CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student_detail` (`student_id`),
  CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (4,'10',10.0,'2017-02-21 00:00:00',NULL,NULL,NULL,NULL,'\0'),(4,'11',9.0,'2017-02-21 00:00:00',NULL,NULL,NULL,NULL,'\0'),(4,'12',8.0,'2017-06-05 00:00:00',NULL,NULL,NULL,NULL,'\0');
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` bit(1) NOT NULL DEFAULT b'0',
  `content` text NOT NULL,
  `asked_by` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `deleted_flag` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fk_asked_by_idx` (`asked_by`),
  CONSTRAINT `fk_asked_by` FOREIGN KEY (`asked_by`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'\0','Ahiihi',4,NULL,NULL,NULL,'\0'),(2,'\0','Có điểm Java chưa thế',6,NULL,NULL,NULL,'\0'),(3,'','Tại sao lại sử dụng PrepareStatement',7,NULL,NULL,NULL,'\0');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `tel` varchar(15) NOT NULL,
  `school` varchar(255) NOT NULL,
  `graduated_year` year(4) NOT NULL,
  `major` varchar(255) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `iq` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'SuperAdmin'),(2,'Admin'),(3,'Teacher'),(4,'Student');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_detail`
--

DROP TABLE IF EXISTS `student_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_detail` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `name` varchar(150) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `id_card` varchar(15) NOT NULL,
  `address` varchar(255) NOT NULL,
  `school` varchar(150) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birthday` date NOT NULL,
  `major` varchar(100) NOT NULL,
  `graduated_year` year(4) NOT NULL,
  `IQ` smallint(6) NOT NULL,
  `note` text,
  `japan_level` varchar(2) DEFAULT NULL,
  `interview` smallint(6) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `student_detail_ibfk2` (`course_id`),
  CONSTRAINT `student_detail_ibfk1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_detail_ibfk2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (4,17,'Nguyễn Văn Chuối','chuoi@gmail.com','123456789','123456789','hà Nội','DHHN','','0000-00-00','CNTT',2017,123,NULL,NULL,NULL,NULL,NULL,NULL),(5,17,'Hà Anh Đức','ducha@gmail.com','123456789','123456789','Hà Nội','T3H','Nam','1999-02-02','CNTT',2018,90,NULL,NULL,NULL,NULL,NULL,NULL),(6,17,'Vũ Minh Công','congvm@gmail.com','123456789','123456789','Thái Nguyên','DHBKHN','NAm','1994-05-12','CNTT',2017,100,NULL,NULL,NULL,NULL,NULL,NULL),(7,17,'Chu Văn Sáng','sangcv@gmail.com','123456789','123456789','Hải Dương','ĐHBKHN','Nam','1992-08-04','CNTT',2016,111,NULL,NULL,NULL,NULL,NULL,NULL),(8,17,'Trịnh Hùng Cường','cuongth@gmail.com','123456789','123456789','Nam Định','ĐH FPT','Nam','1993-01-30','CNTT',2018,102,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `deleted_flag` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('10','Database','Cơ sở dữ liệu',1,NULL,NULL,NULL,'\0'),('11','.Net','ASP.Net',0,NULL,NULL,NULL,'\0'),('12','Java','Ahihihi',0,NULL,NULL,NULL,'\0'),('9','Project','Manage User',1,NULL,NULL,NULL,'\0');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_detail`
--

DROP TABLE IF EXISTS `teacher_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_detail` (
  `teacher_id` int(11) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher_detail_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_detail`
--

LOCK TABLES `teacher_detail` WRITE;
/*!40000 ALTER TABLE `teacher_detail` DISABLE KEYS */;
INSERT INTO `teacher_detail` VALUES (3,'Nguyễn Thị Mai Hương','huongntm@luvina.net','123456789');
/*!40000 ALTER TABLE `teacher_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetables_detail`
--

DROP TABLE IF EXISTS `timetables_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetables_detail` (
  `timetable_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` varchar(20) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `hours_per_day` float DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  KEY `teacher_id` (`teacher_id`),
  KEY `timetable_id` (`timetable_id`),
  KEY `timetables_detail_ibfk_3_idx` (`subject_id`),
  CONSTRAINT `timetables_detail_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_detail` (`teacher_id`),
  CONSTRAINT `timetables_detail_ibfk_2` FOREIGN KEY (`timetable_id`) REFERENCES `timetables_info` (`id`),
  CONSTRAINT `timetables_detail_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetables_detail`
--

LOCK TABLES `timetables_detail` WRITE;
/*!40000 ALTER TABLE `timetables_detail` DISABLE KEYS */;
INSERT INTO `timetables_detail` VALUES (1,'12',3,'2017-02-03 00:00:00',3,'');
/*!40000 ALTER TABLE `timetables_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetables_info`
--

DROP TABLE IF EXISTS `timetables_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetables_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `content` text CHARACTER SET utf8 NOT NULL,
  `note` text CHARACTER SET utf8,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0',
  `place` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `timetables_info_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetables_info`
--

LOCK TABLES `timetables_info` WRITE;
/*!40000 ALTER TABLE `timetables_info` DISABLE KEYS */;
INSERT INTO `timetables_info` VALUES (1,'2017-09-20','2017-09-21',17,'ahihi',NULL,NULL,NULL,NULL,'\0',NULL);
/*!40000 ALTER TABLE `timetables_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`,`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `user_FK_roles_idx` (`role_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'superadmin','123456',1),(2,'admin','123456',2),(3,'teacher','123456',3),(4,'student1','123456',4),(5,'student2','123456',4),(6,'employee1','1234567',4),(7,'employee2','1234567',4),(8,'employee3','123456',4),(9,'employee4','123456',4),(10,'employee5','123456',4);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-21 10:34:21
