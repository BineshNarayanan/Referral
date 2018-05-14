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

-- Dumping structure for table referral.app_user_role
DROP TABLE IF EXISTS `app_user_role`;
CREATE TABLE IF NOT EXISTS `app_user_role` (
  `ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) NOT NULL,
  `ROLE_ID` varchar(36) NOT NULL,
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `APP_USER_ROLE_app_user_ID_fk` (`USER_ID`),
  KEY `APP_USER_ROLE_app_role_ID_fk` (`ROLE_ID`),
  CONSTRAINT `APP_USER_ROLE_app_role_ID_fk` FOREIGN KEY (`ROLE_ID`) REFERENCES `app_role` (`ID`),
  CONSTRAINT `APP_USER_ROLE_app_user_ID_fk` FOREIGN KEY (`USER_ID`) REFERENCES `app_users` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
