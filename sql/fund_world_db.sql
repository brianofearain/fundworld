# Dumping database structure for fund_world_db
DROP DATABASE IF EXISTS `fund_world_db`;
CREATE DATABASE IF NOT EXISTS `fund_world_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fund_world_db`;


# Dumping structure for table fund_world_db.fund_details
DROP TABLE IF EXISTS `fund_details`;
CREATE TABLE IF NOT EXISTS `fund_details` (
  `FUND_ID` int(10) NOT NULL AUTO_INCREMENT,
  `BALANCE_AMOUNT` float NOT NULL,
  `LAST_TRANSACTION_TS` datetime NOT NULL,
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains information about funds';


# Dumping structure for table fund_world_db.payment_details
DROP TABLE IF EXISTS `payment_details`;
CREATE TABLE IF NOT EXISTS `payment_details` (
  `PAYMENT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `FUND_ID` int(10) NOT NULL,
  `FD_CREATION_DATE` date NOT NULL,
  `AMOUNT` int(10) NOT NULL,
  `TENURE` int(10) NOT NULL,
  `ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`FIXED_DEPOSIT_ID`),
  KEY `FK_payment_details_fund_details` (`ACCOUNT_ID`),
  CONSTRAINT `FK_payment_details_fund_details` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `fund_details` (`ACCOUNT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
