/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2023-03-25 16:47:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `venueId` int(10) NOT NULL,
  `venueStateId` int(10) NOT NULL,
  `userId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `age` int(10) DEFAULT NULL,
  `sex` int(10) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phoneNumber` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18', '1', '2020110044', '123456', '13145265858', 'Zhang San', 'zhangsan@163.com');

-- ----------------------------
-- Table structure for venue
-- ----------------------------
DROP TABLE IF EXISTS `venue`;
CREATE TABLE `venue` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of venue
-- ----------------------------
INSERT INTO `venue` VALUES ('1', '1', 'No.1 Table tennis venue', 'Room 1012', '12.5');
INSERT INTO `venue` VALUES ('2', '1', 'No.2 Table tennis venue', 'Room 1232', '12.5');
INSERT INTO `venue` VALUES ('3', '1', 'No.3 Table tennis venue', 'Room 1452', '12.5');
INSERT INTO `venue` VALUES ('4', '1', 'No.4 Table tennis venue', 'Room 14552', '12.5');
INSERT INTO `venue` VALUES ('5', '1', 'No.5 Table tennis venue', 'Room 1242', '12.5');
INSERT INTO `venue` VALUES ('6', '2', 'No.1 Basketball venue', 'Room 121152', '12.5');
INSERT INTO `venue` VALUES ('7', '2', 'No.2 Basketball venue', 'Room 12524', '12.5');
INSERT INTO `venue` VALUES ('8', '2', 'No.3 Basketball venue', 'Room 12582', '12.5');
INSERT INTO `venue` VALUES ('9', '2', 'No.4 Basketball venue', 'Room 127742', '12.5');
INSERT INTO `venue` VALUES ('10', '3', 'No.1 Volleyball venue', 'Room 1255', '12.5');
INSERT INTO `venue` VALUES ('11', '3', 'No.2 Volleyball venue', 'Room 12', '12.5');
INSERT INTO `venue` VALUES ('12', '3', 'No.3 Volleyball venue', 'Room 152', '12.5');
INSERT INTO `venue` VALUES ('13', '3', 'No.4 Volleyball venue', 'Room 155552', '12.5');
INSERT INTO `venue` VALUES ('14', '3', 'No.5 Volleyball venue', 'Room 12452', '12.5');
INSERT INTO `venue` VALUES ('15', '3', 'No.6 Volleyball venue', 'Room 12545', '12.5');
INSERT INTO `venue` VALUES ('16', '3', 'No.7 Volleyball venue', 'Room 1272', '12.5');
INSERT INTO `venue` VALUES ('17', '4', 'No.1 Badminton venue', 'Room 125200', '12.5');
INSERT INTO `venue` VALUES ('18', '4', 'No.2 Badminton venue', 'Room 12452', '12.5');
INSERT INTO `venue` VALUES ('19', '4', 'No.3 Badminton venue', 'Room 12589', '12.5');
INSERT INTO `venue` VALUES ('20', '5', 'No.1 Tennis venue', 'Room 1220', '12.5');
INSERT INTO `venue` VALUES ('21', '5', 'No.2 Tennis venue', 'Room 16552', '12.5');
INSERT INTO `venue` VALUES ('22', '5', 'No.3 Tennis venue', 'Room 12552', '12.5');
INSERT INTO `venue` VALUES ('23', '5', 'No.4 Tennis venue', 'Room 125202', '12.5');
INSERT INTO `venue` VALUES ('24', '5', 'No.5 Tennis venue', 'Room 1', '12.5');
INSERT INTO `venue` VALUES ('25', '5', 'No.6 Tennis venue', 'Room 12515', '12.5');
INSERT INTO `venue` VALUES ('26', '5', 'No.7 Tennis venue', 'Room 125221', '12.5');
INSERT INTO `venue` VALUES ('27', '5', 'No.8 Tennis venue', 'Room 1252005', '12.5');
INSERT INTO `venue` VALUES ('28', '5', 'No.9 Tennis venue', 'Room 125147', '12.5');

-- ----------------------------
-- Table structure for venue_state
-- ----------------------------
DROP TABLE IF EXISTS `venue_state`;
CREATE TABLE `venue_state` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `venueId` int(10) NOT NULL,
  `begin` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `free` int(10) DEFAULT NULL,
  `open` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of venue_state
-- ----------------------------

-- ----------------------------
-- Table structure for venue_type
-- ----------------------------
DROP TABLE IF EXISTS `venue_type`;
CREATE TABLE `venue_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduction` varchar(4096) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of venue_type
-- ----------------------------
INSERT INTO `venue_type` VALUES ('1', 'Table tennis venue', 'The standard table tennis court shall not be less than 14 meters long, 7 meters wide and 4.76 meters high.\nThe training ground should not be less than 12 meters long, 6 meters wide and 4.76 meters high.\nMultiple table tennis tables can be arranged in groups in the recreation venue. When arranged in groups, the distance between the short sides of the table tennis table is greater than or equal to 5 meters, the distance between the long sides of the table is greater than or equal to 2 meters, and the height of the court is greater than or equal to 2.24 meters.');
INSERT INTO `venue_type` VALUES ('2', 'Basketball venue', 'The basketball court is a solid rectangular surface, and the appropriate authority of FIBA shall have the power to approve existing courts within the following range of dimensions: a reduction of 4 meters in length and 2 meters in width, provided that the changes are proportional to each other.\nCeiling or minimum barrier height at least 7 meters.\nCourt lighting should be uniform and sufficient luminosity.\nThe placement of lighting equipment shall not interfere with the vision of the team members.\nAll new courts shall be of the dimensions required by FIBA for major official competitions: 28 metres long, 15 metres wide and free of obstructions (measured from the inside of the boundary).');
INSERT INTO `venue_type` VALUES ('3', 'Volleyball venue', 'The volleyball court is a rectangle with a length of 18 meters and a width of 9 meters.\nThere should be a barrier zone of at least 3 meters wide around.\nAt least 7 meters of barrier-free space from the ground.\nThe barrier-free area outside the sideline of the FIVB World competition venue should be at least 5 meters, outside the end line should be at least 8 meters, and the barrier-free space above the competition venue should be at least 12.5 meters.\nPVC Sport Floor -WanAo Brand PVC Sport Floor -WanAo Brand all boundaries are 5 cm wide, its color is different from the ground and other projects of the site painting line.\nThe long side of the rectangular playing field is the side line and the short side is the end line.\nThe linewidths of the sideline and the end lines are included in the area of the playing field.\nThe center line, under the net, is the connection between the midpoints of the two sides, dividing the playing field into two equal fields.\nEach field draws an offensive line 3 meters from the center line (including its width).\nBetween the center line and the offensive line is the downfield zone.');
INSERT INTO `venue_type` VALUES ('4', 'Badminton venue', 'Badminton court length 13.40 meters, doubles width 6.10 meters, singles width 5.18 meters, doubles court diagonal length =14.723 meters, singles court diagonal length =14.366 meters.\nThe ideal badminton court is made of flexible wood spliced together (as long as the pieces are not spliced vertically).\nChemical synthetic materials have been used as movable plastic courts for international matches.\nAt all levels of grass-roots competition, when the above conditions cannot be met, the competition can also be held on the ground of cement or triad.\nWhether a wooden or synthetic surface is used, it must ensure that the players do not feel too slippery or sticky during competition, and that there is a certain amount of elasticity.');
INSERT INTO `venue_type` VALUES ('5', 'Tennis venue', 'A standard tennis court covers an area of not less than 670 square meters (36.60 meters long × 18.30 meters wide), which is also a standard tennis court around the net or indoor building wall surface net size.\nIn this area, the standard size of the effective doubles court is: 23.77 meters (length) ×10.97 meters (width), the standard size of the effective singles court is: 23.77 meters (length) ×8.23 meters (width), after each end line should leave room for not less than 6.40 meters, in each side line should leave room for not less than 3.66 meters.\nInstall net posts in the court, the center of the two columns is measured, the column spacing is 12.80 meters, the top of the net post is 1.07 meters from the ground.\nThe mainstream tennis court surface is elastic acrylic court, no obstacles.\nTennis courts also have plastic, clay, artificial grass and wood floors.');
