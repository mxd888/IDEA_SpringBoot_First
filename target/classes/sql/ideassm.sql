/*
Navicat MySQL Data Transfer

Source Server         : mxd
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : ideassm

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-12-26 22:10:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userPass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userEmail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userAddr` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
