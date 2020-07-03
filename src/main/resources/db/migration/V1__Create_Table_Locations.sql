CREATE TABLE IF NOT EXISTS `locations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `phone` varchar(14) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);