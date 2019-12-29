/*
Navicat MySQL Data Transfer

Source Server         : mxd
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : ideassm

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-12-26 22:16:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mxd`
-- ----------------------------
DROP TABLE IF EXISTS `mxd`;
CREATE TABLE `mxd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of mxd
-- ----------------------------
