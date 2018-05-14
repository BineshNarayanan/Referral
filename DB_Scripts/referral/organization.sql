-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table referral.organization
DROP TABLE IF EXISTS `organization`;
CREATE TABLE IF NOT EXISTS `organization` (
  `ID` varchar(36) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `INDUSTRY_TYPE` varchar(36) DEFAULT NULL,
  `BUSINESS_DESCRIPTION` varchar(2000) DEFAULT NULL,
  `CREATED_BY` varchar(36) NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_BY` varchar(36) DEFAULT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `organization_industries_ID_fk` (`INDUSTRY_TYPE`),
  KEY `organization_app_users_ID_fk` (`CREATED_BY`),
  KEY `organization_app_users_ID_fk_2` (`UPDATED_BY`),
  CONSTRAINT `organization_app_users_ID_fk` FOREIGN KEY (`CREATED_BY`) REFERENCES `app_users` (`ID`),
  CONSTRAINT `organization_app_users_ID_fk_2` FOREIGN KEY (`UPDATED_BY`) REFERENCES `app_users` (`ID`),
  CONSTRAINT `organization_industries_ID_fk` FOREIGN KEY (`INDUSTRY_TYPE`) REFERENCES `industries` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
