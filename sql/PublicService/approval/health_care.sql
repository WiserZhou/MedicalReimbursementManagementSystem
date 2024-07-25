/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80037
 Source Host           : localhost:3306
 Source Schema         : health_care

 Target Server Type    : MySQL
 Target Server Version : 80037
 File Encoding         : 65001

 Date: 25/07/2024 19:17:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_application_info
-- ----------------------------
DROP TABLE IF EXISTS `t_application_info`;
CREATE TABLE `t_application_info`  (
  `approval_number` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批编号',
  `person_ID` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '人员ID',
  `approval_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批类别\r\n0	人员就诊机构审批\r\n1	药品特检特制审批\r\n2	非定点就医审批\r\n3	家庭病床审批\r\n4	离休二乙定点审批\r\n5	零星报销待遇认定审批类别\r\n6	慢性病特病审批\r\n7	门诊特检特制审批\r\n8	普通待遇审批\r\n9	异地人员登记\r\n10	转院申请\r\n11	追加定额审批\r\n',
  `start_date` datetime NULL DEFAULT NULL COMMENT '开始日期',
  `termination_date` datetime NULL DEFAULT NULL COMMENT '终止日期',
  `medical_institution_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '定点医疗机构编码\r\n0	普通门诊\r\n1	定点药店购药\r\n2	急诊抢救\r\n3	普通住院\r\n4	生育门诊\r\n5	节育门诊\r\n6	生育住院\r\n7	节育住院\r\n8	所有类别\r\n',
  `approval_opinions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批意见',
  `approver` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批人',
  `approval_date` datetime NULL DEFAULT NULL COMMENT '审批日期',
  `approval_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批标志；0否1是'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_application_info
-- ----------------------------
INSERT INTO `t_application_info` VALUES ('ifMPV7ZZTU', 'tPrTv4UcPs', '0', '2010-05-07 00:05:26', '2004-05-07 19:48:31', '0', 'yn2baZ12dN', 'OBP1Al4hsh', '2010-05-16 17:27:37', '1');
INSERT INTO `t_application_info` VALUES ('DIky9xrg7C', 'ilPo8ZQDlu', '1', '2022-06-27 13:22:00', '2011-08-31 14:58:06', '2', '8iV7mVPz3i', 'KsM5g9LyoG', '2011-09-03 23:02:10', '1');
INSERT INTO `t_application_info` VALUES ('ZUq0ozeZr3', 'Hv73e7qdrk', '2', '2011-04-26 02:32:28', '2019-01-25 19:47:47', '2', 'iHQVLh8M2G', 'Crrql0sEFF', '2007-03-14 11:08:06', '0');
INSERT INTO `t_application_info` VALUES ('jFrPVfg3BY', '6ZPyqOG5qn', '3', '2009-06-22 16:10:18', '2005-02-02 07:22:22', '1', 'lRSeck8y8E', '66mF0jLW8C', '2017-06-30 16:40:50', '0');
INSERT INTO `t_application_info` VALUES ('zWagyizdbj', 'aiznAFO6EA', '4', '2015-07-06 00:52:40', '2016-05-10 08:56:35', '4', 'yKsgz6izNx', '46btbK4EVY', '2018-01-08 02:30:55', '0');
INSERT INTO `t_application_info` VALUES ('lBsItrYXOH', 'ovLhDQD5Qu', '4', '2001-10-19 15:38:35', '2012-09-27 11:39:20', '5', 'jKMJkGFOqH', 'FpQFeNVAYs', '2007-08-24 21:53:08', '0');
INSERT INTO `t_application_info` VALUES ('NUmpJdX9BC', 'Y9lvfIejX5', '4', '2023-04-10 05:50:27', '2013-01-21 21:01:59', '2', 'j6dmJM0DTO', 'CEOAv1VKJ0', '2009-10-14 14:37:19', '0');
INSERT INTO `t_application_info` VALUES ('frMJ1UbsEw', 'agkWbcxgW5', '6', '2003-11-18 15:29:16', '2009-06-11 20:22:55', '2', '2o3iC6KQw3', 'Iy5zuLvUwC', '2004-04-17 17:17:00', '1');
INSERT INTO `t_application_info` VALUES ('lZjVJnE4Pq', 'gRYQoNLLC5', '5', '2005-08-31 14:06:56', '2018-06-04 01:35:17', '4', 'WXT2eZshyY', '2EbuluCl7x', '2014-01-05 03:36:31', '1');
INSERT INTO `t_application_info` VALUES ('ICtkB5oeXL', 'VEslKJlFyV', '7', '2000-11-14 13:17:54', '2022-01-04 02:11:22', '5', 'ZgYpGoLCxt', 'Tn17BpZRWi', '2016-02-06 11:51:26', '1');
INSERT INTO `t_application_info` VALUES ('KEPbIwhT1d', 'TAuY8SyVfR', '8', '2022-08-26 08:19:00', '2000-08-09 01:15:16', '1', 'YRdwcd78v2', 'Zn7LVdiacp', '2017-03-10 12:18:04', '1');
INSERT INTO `t_application_info` VALUES ('nyILgtxvJr', 'AIt6asqTZj', '9', '2012-01-24 07:58:44', '2004-08-16 12:03:46', '5', 'iXrJSLlm0b', 'CSkgVP8YAQ', '2021-08-24 20:48:04', '1');
INSERT INTO `t_application_info` VALUES ('bloLW9PNYa', 'ilyAoW2Bd3', '10', '2008-08-31 01:38:48', '2020-08-19 09:59:49', '6', 'qoKda57dwE', 'ebxRFRfAd0', '2015-01-18 02:02:29', '0');
INSERT INTO `t_application_info` VALUES ('8FqPPXoFaA', 'TIRvVqOb8U', '11', '2010-08-26 23:18:21', '2005-05-13 03:41:11', '7', 'jelLmoh2yj', 'Myu6tEXwSo', '2013-06-19 17:26:26', '0');
INSERT INTO `t_application_info` VALUES ('82b6Vx2Xdy', 'yf3wlPiU3O', '11', '2010-08-06 16:37:44', '2015-01-22 10:18:45', '2', 'srTprkp2MU', 'K6yjvHi04P', '2002-10-21 13:26:30', '0');
INSERT INTO `t_application_info` VALUES ('BssXZrnr42', 'UYGT10TDQW', '2', '2012-11-29 05:21:40', '2000-06-30 06:56:40', '3', 'vofmcJ2c1g', 'jmupnxwVkl', '2009-12-16 01:58:24', '1');
INSERT INTO `t_application_info` VALUES ('1vOjUkseS4', 'lw349soaZI', '3', '2006-03-12 07:41:24', '2002-10-06 09:57:24', '4', '0zeoSQC3qa', 'tZWDlng1ug', '2018-12-09 20:29:33', '1');
INSERT INTO `t_application_info` VALUES ('sbFuaIEW1X', 'T4DNTZFXme', '4', '2002-04-05 20:13:39', '2001-07-03 09:28:18', '2', 'ApsUAvXrtk', 'GGRlV5DiWY', '2023-02-07 10:56:00', '1');
INSERT INTO `t_application_info` VALUES ('If2GuzZefP', 'YK5QW76qpv', '5', '2007-12-20 16:36:57', '2012-12-03 20:42:58', '1', 'UZU8Eh2ePN', 'q8kPiCfFN8', '2019-07-10 15:23:59', '1');

-- ----------------------------
-- Table structure for t_special_approval
-- ----------------------------
DROP TABLE IF EXISTS `t_special_approval`;
CREATE TABLE `t_special_approval`  (
  `approval_number` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批编号',
  `person_ID` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '人员ID',
  `approval_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批类别\r\n0	人员就诊机构审批\r\n1	药品特检特制审批\r\n2	非定点就医审批\r\n3	家庭病床审批\r\n4	离休二乙定点审批\r\n5	零星报销待遇认定审批类别\r\n6	慢性病特病审批\r\n7	门诊特检特制审批\r\n8	普通待遇审批\r\n9	异地人员登记\r\n10	转院申请\r\n11	追加定额审批\r\n',
  `start_date` datetime NULL DEFAULT NULL COMMENT '开始日期',
  `termination_date` datetime NULL DEFAULT NULL COMMENT '终止日期',
  `drug_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药品编码',
  `approval_opinions` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批意见',
  `approver` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批人',
  `approval_date` datetime NULL DEFAULT NULL COMMENT '审批日期',
  `approval_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批标志；0否1是'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_special_approval
-- ----------------------------
INSERT INTO `t_special_approval` VALUES ('WYmiHIOzjf', 'SbgUctfjU5', '0', '2022-05-20 16:51:49', '2016-07-27 18:42:36', 'ewAAIJpHAt', 'lCJit7YcQX', 'nD20NUllXw', '2001-10-10 03:32:49', '0');
INSERT INTO `t_special_approval` VALUES ('dyn6gChuLe', 'es85fnVgnw', '2', '2015-12-26 10:42:45', '2018-08-03 09:23:43', 'h04n8MkrJw', 'Z7xnImhSjf', 'Wcl75mq38r', '2016-02-19 10:24:55', '1');
INSERT INTO `t_special_approval` VALUES ('rvgIsKJMDP', '8jeOpqFaOV', '1', '2017-09-28 10:51:48', '2001-03-06 02:38:40', 'JFkw7iWfyP', 'xECAlrEqzI', '4z4pBzEIeT', '2019-10-30 09:44:31', '1');
INSERT INTO `t_special_approval` VALUES ('sJ171bUgeW', 'YPA6bTFWTd', '3', '2024-03-12 19:33:48', '2001-04-07 10:55:19', 'hE9zybmGkK', '4ITKCcbafB', '9FfPgqO92H', '2009-02-11 10:02:18', '0');
INSERT INTO `t_special_approval` VALUES ('YnIFutfbBd', 'eFFoOYlvgS', '4', '2006-11-02 22:38:48', '2003-05-15 07:25:21', 'UlYXXCnUsX', 'p1FCas1FNp', '4gy6oF7o4V', '2019-11-11 13:19:55', '1');
INSERT INTO `t_special_approval` VALUES ('JAEUaIS96q', 'A0cqJCNSNp', '5', '2018-02-07 16:50:47', '2014-03-22 17:03:13', 'jmqFD7W2lS', 'HvAg72AFRw', 'ArP6ckBXsy', '2020-08-20 05:48:25', '0');
INSERT INTO `t_special_approval` VALUES ('CM2ITWWW9c', '9GR50Pb32R', '2', '2022-06-10 16:45:51', '2014-08-15 20:40:54', 'xYOgbYx5CW', 'wLsexlaVaV', 'LXQz8i89eb', '2000-01-11 07:52:51', '1');
INSERT INTO `t_special_approval` VALUES ('Q3XAQkrD1w', 'iyHjOsQI2D', '1', '2023-09-11 13:43:24', '2022-02-07 08:07:23', 'UP1j6NxKwV', 'g05fFizkZW', 'SwuT2RODHF', '2010-12-22 11:44:39', '1');
INSERT INTO `t_special_approval` VALUES ('sLmonef0ZS', 'pw2eSB0mgm', '2', '2008-02-19 06:25:04', '2002-03-03 05:36:13', '9XJYtWiuDi', 'MksBLl7T9F', 'JUiV50dKlL', '2005-03-23 00:03:45', '0');
INSERT INTO `t_special_approval` VALUES ('a3gZdyxiD2', 'BOEXvCjeLD', '3', '2007-09-02 07:53:27', '2009-03-02 13:28:18', 'uYI7Zke0xk', 'uWpbEHJ4Gb', 'oj8MNv6SjC', '2009-02-07 19:44:00', '0');

SET FOREIGN_KEY_CHECKS = 1;
