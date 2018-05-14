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

-- Dumping structure for table referral.post_info
DROP TABLE IF EXISTS `post_info`;
CREATE TABLE IF NOT EXISTS `post_info` (
  `ID` varchar(36) NOT NULL,
  `POST_ID` varchar(36) NOT NULL,
  `TYPE` char(1) NOT NULL COMMENT 'S:SHARED;\nL:LIKE;\nV:VIEW',
  `ACTION_BY` varchar(36) NOT NULL,
  `ACTION_DATE` datetime NOT NULL,
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `post_info_posts_ID_fk` (`POST_ID`),
  KEY `post_info_app_users_ID_fk` (`ACTION_BY`),
  CONSTRAINT `post_info_app_users_ID_fk` FOREIGN KEY (`ACTION_BY`) REFERENCES `app_users` (`ID`),
  CONSTRAINT `post_info_posts_ID_fk` FOREIGN KEY (`POST_ID`) REFERENCES `posts` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
