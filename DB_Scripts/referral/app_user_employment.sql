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

-- Dumping structure for table referral.app_user_employment
DROP TABLE IF EXISTS `app_user_employment`;
CREATE TABLE IF NOT EXISTS `app_user_employment` (
  `ID` varchar(36) NOT NULL,
  `ORG_ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) NOT NULL,
  `IS_CURRENT` tinyint(1) NOT NULL,
  `FROM_DATE` date NOT NULL,
  `TO_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `app_user_employment_app_users_ID_fk` (`USER_ID`),
  KEY `app_user_employment_organization_ID_fk_2` (`ORG_ID`),
  CONSTRAINT `app_user_employment_app_users_ID_fk` FOREIGN KEY (`USER_ID`) REFERENCES `app_users` (`ID`),
  CONSTRAINT `app_user_employment_organization_ID_fk` FOREIGN KEY (`ORG_ID`) REFERENCES `organization` (`ID`),
  CONSTRAINT `app_user_employment_organization_ID_fk_2` FOREIGN KEY (`ORG_ID`) REFERENCES `organization` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
