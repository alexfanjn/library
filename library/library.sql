/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50630
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2017-06-13 21:47:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `b_id` int(5) NOT NULL AUTO_INCREMENT,
  `b_bookName` varchar(20) NOT NULL,
  `b_location` varchar(20) DEFAULT NULL,
  `b_isBorrow` bit(1) NOT NULL,
  `b_createTime` date NOT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('24', 'Java编程思想2', '广工图书馆2', '', '2017-06-03');
INSERT INTO `book` VALUES ('25', 'Java编程思想3', '广工图书馆3', '', '2017-06-03');
INSERT INTO `book` VALUES ('28', 'c++ primer ', '广东工业大学', '', '2017-06-03');
INSERT INTO `book` VALUES ('30', 'hhh', '123456', '', '2017-06-06');
INSERT INTO `book` VALUES ('31', '人机交互-软件工程视角', '广工图书馆9', '', '2017-06-09');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `b_bookId` int(5) NOT NULL,
  `b_userId` int(5) NOT NULL,
  `b_outDate` date NOT NULL,
  `b_createTime` date NOT NULL,
  PRIMARY KEY (`b_bookId`,`b_userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('24', '5', '2017-06-06', '2017-06-06');
INSERT INTO `borrow` VALUES ('24', '7', '2017-06-09', '2017-06-09');
INSERT INTO `borrow` VALUES ('30', '5', '2017-06-06', '2017-06-06');
INSERT INTO `borrow` VALUES ('30', '7', '2017-06-09', '2017-06-09');
INSERT INTO `borrow` VALUES ('31', '7', '2017-06-09', '2017-06-09');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(5) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) NOT NULL,
  `u_major` varchar(20) DEFAULT NULL,
  `u_userClass` varchar(20) DEFAULT NULL,
  `u_createTime` date DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'fff', '软件工程', '3', '2017-06-06');
INSERT INTO `user` VALUES ('7', 'fang', '软件工程', '1', '2017-06-09');
