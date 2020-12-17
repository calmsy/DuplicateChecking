/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : dcs

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-12-17 22:23:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `class_id` varchar(10) NOT NULL,
  `class_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1班');
INSERT INTO `classes` VALUES ('2', '2班');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(10) NOT NULL,
  `course_name` varchar(10) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文', '32', '3');
INSERT INTO `course` VALUES ('2', '数学', '32', '3');
INSERT INTO `course` VALUES ('3', '英语', '16', '2');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `student_id` varchar(10) NOT NULL,
  `course_id` varchar(10) NOT NULL,
  `usual_score` double DEFAULT NULL,
  `final_score` double DEFAULT NULL,
  `total_score` double DEFAULT NULL,
  PRIMARY KEY (`student_id`,`course_id`) USING BTREE,
  KEY `course_id` (`course_id`) USING BTREE,
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '5', '5', '5');
INSERT INTO `score` VALUES ('1', '2', '15', '50', '65');
INSERT INTO `score` VALUES ('1', '3', '10', '60', '70');
INSERT INTO `score` VALUES ('2', '1', '10', '50', '60');
INSERT INTO `score` VALUES ('2', '2', '15', '60', '75');
INSERT INTO `score` VALUES ('2', '3', '10', '50', '60');
INSERT INTO `score` VALUES ('3', '1', '15', '60', '75');
INSERT INTO `score` VALUES ('3', '2', '10', '50', '60');
INSERT INTO `score` VALUES ('3', '3', '15', '60', '75');
INSERT INTO `score` VALUES ('4', '1', '10', '50', '60');
INSERT INTO `score` VALUES ('4', '2', '15', '50', '65');
INSERT INTO `score` VALUES ('4', '3', '10', '60', '70');
INSERT INTO `score` VALUES ('5', '1', '15', '60', '75');
INSERT INTO `score` VALUES ('5', '2', '10', '50', '60');
INSERT INTO `score` VALUES ('5', '3', '15', '50', '65');
INSERT INTO `score` VALUES ('6', '1', '10', '60', '70');
INSERT INTO `score` VALUES ('6', '2', '15', '60', '75');
INSERT INTO `score` VALUES ('6', '3', '10', '50', '60');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(10) NOT NULL,
  `student_name` varchar(10) DEFAULT NULL,
  `sex` enum('F','M') DEFAULT NULL,
  `college` varchar(10) DEFAULT NULL,
  `class_id` varchar(10) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  KEY `class_id` (`class_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', 'F', '软件学院', '1', '11111');
INSERT INTO `student` VALUES ('2', '小红', 'M', '软件学院', '1', '22222');
INSERT INTO `student` VALUES ('3', '小蓝', 'M', '软件学院', '1', '33333');
INSERT INTO `student` VALUES ('4', '张三', 'F', '软件学院', '2', '44444');
INSERT INTO `student` VALUES ('5', '李四', 'F', '软件学院', '2', '55555');
INSERT INTO `student` VALUES ('6', '王五', 'F', '软件学院', '2', '66666');
