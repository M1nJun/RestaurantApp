-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `restaurant_reviews`
--

DROP TABLE IF EXISTS `restaurant_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant_reviews` (
  `reviewID` int NOT NULL AUTO_INCREMENT,
  `restaurantID` varchar(36) DEFAULT NULL,
  `userID` varchar(36) DEFAULT NULL,
  `posted` date NOT NULL,
  `quality` int NOT NULL,
  `ambiance` int NOT NULL,
  `price` int NOT NULL,
  `comment` text,
  PRIMARY KEY (`reviewID`),
  KEY `restaurantID` (`restaurantID`),
  KEY `userID` (`userID`),
  CONSTRAINT `restaurant_reviews_ibfk_1` FOREIGN KEY (`restaurantID`) REFERENCES `restaurant_restaurant` (`restaurantID`),
  CONSTRAINT `restaurant_reviews_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `restaurant_user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_reviews`
--

LOCK TABLES `restaurant_reviews` WRITE;
/*!40000 ALTER TABLE `restaurant_reviews` DISABLE KEYS */;
INSERT INTO `restaurant_reviews` VALUES (1,'ecc9db02-f837-11ee-a9e4-0c6bf382b1f2',NULL,'2024-04-11',4,4,5,'Good'),(2,'ecc9db02-f837-11ee-a9e4-0c6bf382b1f2','cb4d1b48-f886-11ee-a9e4-0c6bf382b1f2','2024-04-11',4,4,5,'Good'),(3,'887061ee-f8e1-11ee-a9e4-0c6bf382b1f2','9179be84-f8e1-11ee-a9e4-0c6bf382b1f2','2024-04-11',3,4,5,'I don\'t go there');
/*!40000 ALTER TABLE `restaurant_reviews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-12 16:13:41
