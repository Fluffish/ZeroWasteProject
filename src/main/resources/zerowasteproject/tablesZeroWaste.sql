-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: zerowasteproject
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `characterize_food`
--

DROP TABLE IF EXISTS `characterize_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characterize_food` (
  `id_food` int NOT NULL,
  `id_food_type` int NOT NULL,
  PRIMARY KEY (`id_food`,`id_food_type`),
  KEY `fk_foodtype_characterize_idx` (`id_food_type`),
  CONSTRAINT `fk_food_characterize` FOREIGN KEY (`id_food`) REFERENCES `food` (`id_food`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_foodtype_characterize` FOREIGN KEY (`id_food_type`) REFERENCES `food_type` (`id_food_type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterize_food`
--

LOCK TABLES `characterize_food` WRITE;
/*!40000 ALTER TABLE `characterize_food` DISABLE KEYS */;
INSERT INTO `characterize_food` VALUES (1,1),(2,2),(3,2),(6,2),(7,3),(8,3),(4,7),(5,7),(6,7),(9,8);
/*!40000 ALTER TABLE `characterize_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterize_recipe`
--

DROP TABLE IF EXISTS `characterize_recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `characterize_recipe` (
  `id_recipe` int NOT NULL,
  `id_recipe_type` int NOT NULL,
  PRIMARY KEY (`id_recipe`,`id_recipe_type`),
  KEY `fk_id_recipe_type_idx` (`id_recipe_type`),
  CONSTRAINT `fk_id_recipe_carac` FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`),
  CONSTRAINT `fk_id_recipe_type` FOREIGN KEY (`id_recipe_type`) REFERENCES `recipe_type` (`id_recipe_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterize_recipe`
--

LOCK TABLES `characterize_recipe` WRITE;
/*!40000 ALTER TABLE `characterize_recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `characterize_recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id_food` int NOT NULL AUTO_INCREMENT,
  `food_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id_food`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'Steak'),(2,'Carotte'),(3,'Tomate'),(4,'Pâtes'),(5,'Riz'),(6,'Frites'),(7,'Compotes'),(8,'Fraise'),(9,'Muesli');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_type`
--

DROP TABLE IF EXISTS `food_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_type` (
  `id_food_type` int NOT NULL AUTO_INCREMENT,
  `food_type_name` varchar(40) NOT NULL,
  PRIMARY KEY (`id_food_type`),
  UNIQUE KEY `food_type_name_UNIQUE` (`food_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_type`
--

LOCK TABLES `food_type` WRITE;
/*!40000 ALTER TABLE `food_type` DISABLE KEYS */;
INSERT INTO `food_type` VALUES (8,'Céréales'),(7,'Féculent'),(5,'Fromage'),(3,'Fruit'),(4,'Laitage'),(2,'Légume'),(1,'Viande'),(6,'Yaourt');
/*!40000 ALTER TABLE `food_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id_recipe` int NOT NULL,
  `recipe_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_recipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_type`
--

DROP TABLE IF EXISTS `recipe_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe_type` (
  `id_recipe_type` int NOT NULL AUTO_INCREMENT,
  `recipe_type_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_recipe_type`),
  UNIQUE KEY `recipe_type_name_UNIQUE` (`recipe_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_type`
--

LOCK TABLES `recipe_type` WRITE;
/*!40000 ALTER TABLE `recipe_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipe_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_type`
--

DROP TABLE IF EXISTS `storage_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage_type` (
  `id_storage` int NOT NULL AUTO_INCREMENT,
  `storage_name` varchar(45) NOT NULL,
  `storage_temp` float NOT NULL,
  PRIMARY KEY (`id_storage`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_type`
--

LOCK TABLES `storage_type` WRITE;
/*!40000 ALTER TABLE `storage_type` DISABLE KEYS */;
INSERT INTO `storage_type` VALUES (1,'Placard',20),(3,'Placard',15),(4,'Frigo',4),(5,'Entrepot',10),(6,'Placard',18),(7,'Frigo',2),(8,'Congélateur',-20),(9,'Entrepot',-20),(10,'Placard',10);
/*!40000 ALTER TABLE `storage_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `use_food`
--

DROP TABLE IF EXISTS `use_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `use_food` (
  `id_recipe` int NOT NULL,
  `id_food` int NOT NULL,
  `quantity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_recipe`,`id_food`),
  KEY `fk_id_food_idx` (`id_food`),
  CONSTRAINT `fk_id_food_recipe` FOREIGN KEY (`id_food`) REFERENCES `food` (`id_food`) ON UPDATE CASCADE,
  CONSTRAINT `fk_id_recipe` FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id_recipe`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `use_food`
--

LOCK TABLES `use_food` WRITE;
/*!40000 ALTER TABLE `use_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `use_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_possess`
--

DROP TABLE IF EXISTS `user_possess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_possess` (
  `id_user` int NOT NULL,
  `id_storage` int NOT NULL,
  `id_food` int NOT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  `food_limit_date` timestamp NOT NULL,
  `food_add_date` timestamp NOT NULL,
  `food_price` float NOT NULL,
  PRIMARY KEY (`id_food`,`id_storage`,`id_user`),
  KEY `fk_id_user_possess_idx` (`id_user`),
  KEY `fk_id_storage_possess_idx` (`id_storage`),
  CONSTRAINT `fk_id_food_possess` FOREIGN KEY (`id_food`) REFERENCES `food` (`id_food`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_storage_possess` FOREIGN KEY (`id_storage`) REFERENCES `storage_type` (`id_storage`),
  CONSTRAINT `fk_id_user_possess` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_possess`
--

LOCK TABLES `user_possess` WRITE;
/*!40000 ALTER TABLE `user_possess` DISABLE KEYS */;
INSERT INTO `user_possess` VALUES (2,3,4,'500g','2021-05-22 22:00:00','2021-03-19 23:00:00',2.5),(2,3,5,'500g','2021-07-22 22:00:00','2021-05-17 22:00:00',2.5);
/*!40000 ALTER TABLE `user_possess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `mail_user` varchar(100) NOT NULL,
  `tel_user` varchar(20) NOT NULL,
  `user_max_budget` int NOT NULL,
  `user_current_budget` int NOT NULL,
  `is_admin` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Amel','adminZeroWaste','amel@zerowaste.com','06.07.06.07.06',200,0,1),(2,'Florent','adminZeroWaste','florent@zerowaste.com','06.06.06.06.06',100,0,1),(3,'Chahinda','adminZeroWaste','chahinda@zerowaste.com','07.07.07.07.07',150,0,1),(4,'Mayas','adminZeroWaste','mayas@zerowaste.com','07.06.07.06.07',150,0,1),(5,'Abdessettar','adminZeroWaste','abdessettar@zerowaste.com','06.06.07.07.06',150,0,1);
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

-- Dump completed on 2021-05-18 15:36:54
