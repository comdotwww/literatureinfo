/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : arxiv

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2021-04-06 08:51:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_name` varchar(255) NOT NULL,
  `author_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`author_id`),
  KEY `author_name` (`author_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9624 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paper_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `abstract_content` text NOT NULL,
  `pdf_url` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paper_author
-- ----------------------------
DROP TABLE IF EXISTS `paper_author`;
CREATE TABLE `paper_author` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(255) NOT NULL,
  `paper_id` varchar(255) NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `paper_id` (`paper_id`),
  KEY `author_name` (`author_name`),
  CONSTRAINT `author_name` FOREIGN KEY (`author_name`) REFERENCES `author` (`author_name`),
  CONSTRAINT `paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12264 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paper_tag
-- ----------------------------
DROP TABLE IF EXISTS `paper_tag`;
CREATE TABLE `paper_tag` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) NOT NULL,
  `paper_id` varchar(255) NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `paperid` (`paper_id`),
  KEY `tag_name` (`tag_name`),
  CONSTRAINT `paperid` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `tag_name` FOREIGN KEY (`tag_name`) REFERENCES `tag` (`tag_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4640 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) NOT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `tag_name` (`tag_name`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;
