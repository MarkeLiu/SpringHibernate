/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50542
Source Host           : localhost:3306
Source Database       : hibernate

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2016-04-23 12:19:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` varchar(36) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `addTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `tb_user_u` (`userName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
