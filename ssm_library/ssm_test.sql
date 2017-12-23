/*
Navicat MySQL Data Transfer

Source Server         : crab
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : ssm_test

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-12-22 17:39:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `price_double` double DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stu_book_fk` (`stu_id`),
  CONSTRAINT `stu_book_fk` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', 'ahaha', '40.2', '20');
INSERT INTO `book` VALUES ('3', 'xiyouji', '40.2', '20');
INSERT INTO `book` VALUES ('4', 'xiyouji', '40.2', '20');
INSERT INTO `book` VALUES ('5', 'xiyouji', '40.2', '20');
INSERT INTO `book` VALUES ('6', 'xiyouji', '40.2', '20');
INSERT INTO `book` VALUES ('9', '金瓶梅', '20.2', '20');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('14', 'xiaoming', '18', '123321');
INSERT INTO `student` VALUES ('15', 'xiaoming', '18', '123321');
INSERT INTO `student` VALUES ('16', 'xiaoming', '18', '123321');
INSERT INTO `student` VALUES ('18', 'xiaoming', '18', '123321');
INSERT INTO `student` VALUES ('19', 'xiaoming', '18', '123321');
INSERT INTO `student` VALUES ('20', 'xiaozhi', '18', '123321');
INSERT INTO `student` VALUES ('21', 'xiaozhi', '18', '123321');
