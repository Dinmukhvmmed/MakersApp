-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: makers_app
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `music` (
  `id` int NOT NULL,
  `album` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=Rif-RTvmmss','Starboy',0,2016),(2,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=WFO7r3g-JBc','Nothing Without You',0,2016),(3,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=5v1TOFULOWA','I Feel It Coming',0,2016),(4,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=YQ-qToZUybM','Die for You',0,2016),(5,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=VQ5XQYpx2mg','True Colors',0,2016),(6,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=eXDU9um19HM','Secrets',0,2016),(7,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=h_VCgsWLmY4','Reminder',0,2016),(8,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=7uf8xkknCxQ','False Alarm',0,2016),(9,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=sK-T-cmznY8','Sidewalks',0,2016),(10,'Starboy','The Weeknd','pop','https://www.youtube.com/watch?v=iBnLoAE9kUE','A Lonely Night',0,2016),(11,'Appetite for Destruction','Guns NRoses','rock','https://www.youtube.com/watch?v=1w7OgIMMRc4','Sweet Child OMine',0,1987),(12,'Led Zeppelin IV','Led Zeppelin','rock','https://www.youtube.com/watch?v=QkF3oxziUI4','Stairway to Heaven',0,1971),(13,'The Dark Side of the Moon','Pink Floyd','https://www.youtube.com/watch?v=-0kcet4aPpQ','rock','Money',0,1973),(14,'Back in Black','AC/DC','rock','https://www.youtube.com/watch?v=pAgnJDJN4VA','Back in Black',0,1980),(15,'Hysteria','Def Leppard','rock','https://www.youtube.com/watch?v=0UIB9Y4OFPs','Pour Some Sugar on Me',0,1987),(16,'Nevermind','Nirvana','rock','https://www.youtube.com/watch?v=hTWKbfoikeg','Smells Like Teen Spirit',0,1991),(17,'Ten','Pearl Jam','rock','https://www.youtube.com/watch?v=qM0zINtulhM','Alive',0,1991),(18,'Paranoid','Black Sabbath','rock','https://www.youtube.com/watch?v=0qanF-91aJo','Paranoid',0,1970),(19,'Highway to Hell','AC/DC','rock','https://www.youtube.com/watch?v=l482T0yNkeo','Highway to Hell',0,1979),(20,'Hotel California','Eagles','rock','https://www.youtube.com/watch?v=09839DpTctU','Hotel California',0,1976);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18 11:43:24
