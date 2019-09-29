-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rentastic
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` varchar(10) NOT NULL,
  `customername` varchar(50) NOT NULL,
  `customeremail` varchar(50) NOT NULL,
  `customerpassword` varchar(255) NOT NULL,
  `customercontact` varchar(20) NOT NULL,
  `customeraddress` varchar(255) NOT NULL,
  `customergender` varchar(15) DEFAULT NULL,
  `customerwallet` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'c1','Ayushman Khurrana','ayushman@gmail.com','ayushman','7979567233',' Homesweet Housing Complex , Near Phoenix Mall ,Bengaluru, pin-450060','male',9000),(2,'c2','Rajkumar Rao','rajkumar@gmail.com','rajkumar','8765982020',' 24/A HBC Lane , Near sundarvan Park ,Pune, pin-560044','male',15000),(3,'c3','Vicky Kaushal','vicky@gmail.com','vicky','8765498790',' Devlok Apartments, Clubhouse Road,Near Apex Hospital, sharjahpur ,hyderabad, pin-330065','male',12000),(4,'EcSNPq','Alia Bhatt','alia@email.com','$2a$10$RrJ04JRBhdyNDmLiPwPYMObES3iwplp6l/Ev6T4.BWuZn4pn1X5iK','7005675678','roahnishika apartments , Boganhalli , Pune, pin-760045','female',10000),(5,'DAjF8k','Shraddha Kapoor','shraddha@email.com','$2a$10$rfL7WctLyz4RBdVwUQWTUusnDGH0A4zl4UU7na1xHsxS28C0f7iui','7005676547','indralok apartments , Boganhalli , Pune, pin-760045','female',10000),(8,'CtfssY','Anuj Singh','anuj60360@gmail.com','$2a$10$9Lm9OErCX9gttaQWJ1DL0uSdfKhqk/Ej8ypF1d2.dDeYACF7TLWbm','8989720724','bajrang nagar','male',0),(9,'2OFZts','Anuj Singh','shubha1256@gmail.com','$2a$10$W.sh80cnT5f7ttjYGCrXv.dz9a98VVdjV8LcJ8SOrZRe/ifNJU4c2','87887888','bajrang nagra','male',0),(10,'aEXl07','priyanshu mishra','pmishra4509@gmail.com','$2a$10$XNPld9cwVsHeP6QEChfJLeEVCtDRRkNuTOe1yCk31iM5/0wqepwbC','8989720724','bajrang nagar rewa','male',0),(11,'VwUwIV','Poorvik Gambhir','subham@mgmail.in','$2a$10$ZNTVGW/F9Us/AWqkpg3qKupiPpstgnucpkjdBRhSkvlaAvF1lCYZu','8989720724','banglore','male',0),(12,'Q74Vfw','Smriti Chaurasia','chaurasia.smriti5@gmail.com','$2a$10$iNg8GtaCjv7qWGmVEcZ60OM4IwVEY7pDT/QH0VmGN97c8nJx4YPOS','8989720724','pune','female',0),(13,'zSDUWA','Laila ahuja','laila@234gmail.com','$2a$10$YvwpnlW1VmWws4IeArS4.umcR9LE4p/s4FzPsAPyxKWE5W/jvW0ma','89897209345','hyderabad','female',0),(14,'PGACsU','thrki khan','thrkiK@234gmail.com','$2a$10$7PzafxAbTd0b3/He/F8srOvaAZa/5/5kiavFC7pQ7RTCLP6jKJLxS','12345678','hyderabad','male',0),(15,'7MBeLu','aftab Singh','aftab@334gmail.com','$2a$10$dtbFQNPDaHYrf.7q9/ZKCOQSmXh9zPMifS2tObyTGpUAaG.OuasXe','8989720724','banglore','male',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-29 22:21:39
