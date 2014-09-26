-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema apk_manager
--

CREATE DATABASE IF NOT EXISTS apk_manager;
USE apk_manager;

--
-- Definition of table `app_download_details`
--

DROP TABLE IF EXISTS `app_download_details`;
CREATE TABLE `app_download_details` (
  `SL_NO` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `APP_ID` int(10) unsigned NOT NULL,
  `DATE` datetime NOT NULL,
  `DOWNLOAD_IP` varchar(45) NOT NULL,
  PRIMARY KEY (`SL_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_download_details`
--

/*!40000 ALTER TABLE `app_download_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_download_details` ENABLE KEYS */;


--
-- Definition of table `application_details`
--

DROP TABLE IF EXISTS `application_details`;
CREATE TABLE `application_details` (
  `APP_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `APP_NAME` varchar(45) NOT NULL,
  `APP_OWNER` varchar(45) NOT NULL,
  `APP_VER` varchar(45) NOT NULL,
  `DATE` datetime NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`APP_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `application_details`
--

/*!40000 ALTER TABLE `application_details` DISABLE KEYS */;
INSERT INTO `application_details` (`APP_ID`,`APP_NAME`,`APP_OWNER`,`APP_VER`,`DATE`,`IS_ACTIVE`) VALUES 
 (1,'app1','owner1','V1.0','2014-09-23 15:50:48',1),
 (2,'app2','owner1','V1.0','2014-09-23 15:51:38',0),
 (3,'TestApk','Dush','1.0','2014-09-24 13:42:12',1);
/*!40000 ALTER TABLE `application_details` ENABLE KEYS */;


--
-- Definition of table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `SL_NO` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `MIDDLE_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `DEPARTMENT` varchar(45) DEFAULT NULL,
  `CONTACT` varchar(45) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`SL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` (`SL_NO`,`USER_NAME`,`PASSWORD`,`FIRST_NAME`,`MIDDLE_NAME`,`LAST_NAME`,`DEPARTMENT`,`CONTACT`,`IS_ACTIVE`) VALUES 
 (1,'admin','admin','Admin','ad','ad','adad','ad',1);
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
