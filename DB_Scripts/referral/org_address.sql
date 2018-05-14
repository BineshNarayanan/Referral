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

-- Dumping structure for table referral.org_address
DROP TABLE IF EXISTS `org_address`;
CREATE TABLE IF NOT EXISTS `org_address` (
  `ID` varchar(36) NOT NULL,
  `ORG_ID` varchar(36) NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `CITY` varchar(36) DEFAULT NULL,
  `STATE` varchar(36) DEFAULT NULL,
  `COUNTRY` varchar(36) DEFAULT NULL,
  `DISTRICT` varchar(36) DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  KEY `org_address_organization_ID_fk` (`ORG_ID`),
  CONSTRAINT `org_address_organization_ID_fk` FOREIGN KEY (`ORG_ID`) REFERENCES `organization` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
