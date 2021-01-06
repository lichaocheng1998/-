/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.13 : Database - guanggao_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`guanggao_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `guanggao_db`;

/*Table structure for table `guanggao_table` */

DROP TABLE IF EXISTS `guanggao_table`;

CREATE TABLE `guanggao_table` (
  `id` char(60) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `imageFile` longblob,
  `serialNumber` varchar(60) NOT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `FK_register_guanggao` (`id`),
  CONSTRAINT `FK_register_guanggao` FOREIGN KEY (`id`) REFERENCES `register_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `manage_table` */

DROP TABLE IF EXISTS `manage_table`;

CREATE TABLE `manage_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` char(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Table structure for table `register_table` */

DROP TABLE IF EXISTS `register_table`;

CREATE TABLE `register_table` (
  `id` char(60) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
