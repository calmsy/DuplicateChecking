/*
 Navicat Premium Data Transfer

 Source Server         : MySQL8.0
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : dcs

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 17/12/2020 14:07:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_score
-- ----------------------------
DROP TABLE IF EXISTS `class_score`;
CREATE TABLE `class_score`  (
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usual_score` double NULL DEFAULT NULL,
  `avg_usual_score` double NULL DEFAULT NULL,
  `final_score` double NULL DEFAULT NULL,
  `avg_final_score` double NULL DEFAULT NULL,
  `total_score` double NULL DEFAULT NULL,
  `avg_total_score` double NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_score
-- ----------------------------
INSERT INTO `class_score` VALUES ('1', 223, 223, 224, 224, 223, 224);
INSERT INTO `class_score` VALUES ('3', 360, 180, 360, 180, 360, 180);

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', 'Java1');
INSERT INTO `classes` VALUES ('2', 'Java2');
INSERT INTO `classes` VALUES ('3', 'Java3');
INSERT INTO `classes` VALUES ('4', 'Java4');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `period` int NULL DEFAULT NULL,
  `credit` double NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'computer', 20, 3);
INSERT INTO `course` VALUES ('2', 'JavaEE', 18, 3);
INSERT INTO `course` VALUES ('3', 'Oracle', 20, 2);
INSERT INTO `course` VALUES ('4', 'html', 18, 3);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `course_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `usual_score` double NULL DEFAULT NULL,
  `final_score` double NULL DEFAULT NULL,
  `total_score` double NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `course_id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('184804028', '1', 100, 100, 100);
INSERT INTO `score` VALUES ('184804028', '2', 90, 90, 90);
INSERT INTO `score` VALUES ('184804028', '3', 80, 80, 80);
INSERT INTO `score` VALUES ('184804028', '4', 80, 90, 90);
INSERT INTO `score` VALUES ('184804029', '1', 90, 90, 90);
INSERT INTO `score` VALUES ('184804029', '2', 80, 80, 80);
INSERT INTO `score` VALUES ('184804029', '3', 90, 90, 90);
INSERT INTO `score` VALUES ('184804029', '4', 80, 80, 80);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` enum('f','m') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('184804028', '程钰杰', 'm', '软件学院', '3', '15837200762');
INSERT INTO `student` VALUES ('184804029', 'ddd', 'm', '软件学院', '3', '111');

SET FOREIGN_KEY_CHECKS = 1;
