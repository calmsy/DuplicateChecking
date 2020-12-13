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

 Date: 13/12/2020 17:24:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1班');
INSERT INTO `class` VALUES ('2', '2班');

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
INSERT INTO `class_score` VALUES ('1', 110, 36.6, 490, 163.3, 600, 200);
INSERT INTO `class_score` VALUES ('2', 110, 36.6, 490, 163.3, 600, 200);

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
INSERT INTO `course` VALUES ('1', '语文', 32, 3);
INSERT INTO `course` VALUES ('2', '数学', 32, 3);
INSERT INTO `course` VALUES ('3', '英语', 16, 2);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
INSERT INTO `score` VALUES ('1', '1', 10, 50, 60);
INSERT INTO `score` VALUES ('1', '2', 15, 50, 65);
INSERT INTO `score` VALUES ('1', '3', 10, 60, 70);
INSERT INTO `score` VALUES ('2', '1', 10, 50, 60);
INSERT INTO `score` VALUES ('2', '2', 15, 60, 75);
INSERT INTO `score` VALUES ('2', '3', 10, 50, 60);
INSERT INTO `score` VALUES ('3', '1', 15, 60, 75);
INSERT INTO `score` VALUES ('3', '2', 10, 50, 60);
INSERT INTO `score` VALUES ('3', '3', 15, 60, 75);
INSERT INTO `score` VALUES ('4', '1', 10, 50, 60);
INSERT INTO `score` VALUES ('4', '2', 15, 50, 65);
INSERT INTO `score` VALUES ('4', '3', 10, 60, 70);
INSERT INTO `score` VALUES ('5', '1', 15, 60, 75);
INSERT INTO `score` VALUES ('5', '2', 10, 50, 60);
INSERT INTO `score` VALUES ('5', '3', 15, 50, 65);
INSERT INTO `score` VALUES ('6', '1', 10, 60, 70);
INSERT INTO `score` VALUES ('6', '2', 15, 60, 75);
INSERT INTO `score` VALUES ('6', '3', 10, 50, 60);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` enum('F','M') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', 'F', '软件学院', '1', '11111');
INSERT INTO `student` VALUES ('2', '小红', 'M', '软件学院', '1', '22222');
INSERT INTO `student` VALUES ('3', '小蓝', 'M', '软件学院', '1', '33333');
INSERT INTO `student` VALUES ('4', '张三', 'F', '软件学院', '2', '44444');
INSERT INTO `student` VALUES ('5', '李四', 'F', '软件学院', '2', '55555');
INSERT INTO `student` VALUES ('6', '王五', 'F', '软件学院', '2', '66666');

SET FOREIGN_KEY_CHECKS = 1;
