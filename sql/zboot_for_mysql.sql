
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_data_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_dict`;
CREATE TABLE `sys_data_dict`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据字典名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_data_dict
-- ----------------------------
INSERT INTO `sys_data_dict` VALUES (1, 'sys', '系统简写', '2020-11-24 10:42:13', '2020-11-24 10:42:25', 'admin', 'admin');
INSERT INTO `sys_data_dict` VALUES (2, 'dep', '部门简写', '2020-11-24 10:45:17', '2020-11-24 10:45:17', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_dep
-- ----------------------------
DROP TABLE IF EXISTS `sys_dep`;
CREATE TABLE `sys_dep`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父节点',
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dep
-- ----------------------------
INSERT INTO `sys_dep` VALUES (1, -1, '研发部', 1, '2020-10-30 16:02:27', '2020-11-16 11:24:15', 'admin', NULL);
INSERT INTO `sys_dep` VALUES (2, -1, '测试部', 2, '2020-10-30 16:02:29', '2020-11-23 16:11:44', 'admin', NULL);
INSERT INTO `sys_dep` VALUES (3, 1, '研发大队', 1, '2020-11-01 16:48:23', '2020-11-23 17:10:03', 'admin', 'admin');
INSERT INTO `sys_dep` VALUES (4, 2, '测试小分队', 4, '2020-11-01 17:18:20', '2020-11-01 19:20:17', 'admin', NULL);
INSERT INTO `sys_dep` VALUES (8, 1, '研发2队', 6, '2020-11-02 14:28:17', '2020-11-18 13:43:29', 'admin', NULL);
INSERT INTO `sys_dep` VALUES (9, 1, '研发副队', 3, '2020-11-23 17:11:11', '2020-11-23 17:11:11', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_dep_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_dep_user`;
CREATE TABLE `sys_dep_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dep_id` bigint(20) NULL DEFAULT NULL COMMENT '部门编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门用户关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dep_user
-- ----------------------------
INSERT INTO `sys_dep_user` VALUES (1, 3, 1);
INSERT INTO `sys_dep_user` VALUES (3, 4, 8);
INSERT INTO `sys_dep_user` VALUES (5, 8, 2);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `ipaddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `oprator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作',
  `usage_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '耗时',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4072 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (4051, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-23 17:08:47');
INSERT INTO `sys_log` VALUES (4052, 'admin', '0:0:0:0:0:0:0:1', '更新:修改部门', '24', '2020-11-23 17:10:03');
INSERT INTO `sys_log` VALUES (4053, 'admin', '0:0:0:0:0:0:0:1', '添加:添加部门', '15', '2020-11-23 17:11:11');
INSERT INTO `sys_log` VALUES (4054, 'admin', '0:0:0:0:0:0:0:1', '删除:修改角色', '18', '2020-11-23 17:34:16');
INSERT INTO `sys_log` VALUES (4055, 'admin', '127.0.0.1', '用户登陆', '1', '2020-11-24 09:32:54');
INSERT INTO `sys_log` VALUES (4056, 'admin', '0:0:0:0:0:0:0:1', '添加:添加菜单', '9', '2020-11-24 10:38:00');
INSERT INTO `sys_log` VALUES (4057, 'admin', '0:0:0:0:0:0:0:1', '添加:添加菜单', '9', '2020-11-24 10:40:04');
INSERT INTO `sys_log` VALUES (4058, 'admin', '0:0:0:0:0:0:0:1', '添加:添加菜单', '8', '2020-11-24 10:40:49');
INSERT INTO `sys_log` VALUES (4059, 'admin', '0:0:0:0:0:0:0:1', '更新:添加修改菜单权限', '12', '2020-11-24 10:41:08');
INSERT INTO `sys_log` VALUES (4060, 'admin', '0:0:0:0:0:0:0:1', '添加:添加数据字典', '8', '2020-11-24 10:42:13');
INSERT INTO `sys_log` VALUES (4061, 'admin', '0:0:0:0:0:0:0:1', '更新:修改数据字典', '9', '2020-11-24 10:42:25');
INSERT INTO `sys_log` VALUES (4062, 'admin', '0:0:0:0:0:0:0:1', '添加:添加数据字典', '17', '2020-11-24 10:45:17');
INSERT INTO `sys_log` VALUES (4063, 'admin', '0:0:0:0:0:0:0:1', '添加:添加数据字典', '17', '2020-11-24 10:54:08');
INSERT INTO `sys_log` VALUES (4064, 'admin', '0:0:0:0:0:0:0:1', '删除:删除数据字典', '10', '2020-11-24 10:54:11');
INSERT INTO `sys_log` VALUES (4065, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 10:58:43');
INSERT INTO `sys_log` VALUES (4066, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 11:59:25');
INSERT INTO `sys_log` VALUES (4067, 'test', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 13:40:04');
INSERT INTO `sys_log` VALUES (4068, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 13:41:04');
INSERT INTO `sys_log` VALUES (4069, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-25 08:56:22');
INSERT INTO `sys_log` VALUES (4070, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-25 10:16:24');
INSERT INTO `sys_log` VALUES (4071, 'admin', '0:0:0:0:0:0:0:1', '更新:修改用户', '80', '2020-11-25 10:16:34');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单权限',
  `icon_cls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单组件',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单类型（1目录，2菜单，3按钮）',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, NULL, '', NULL, 'el-icon-setting', NULL, -1, 2, '2020-10-16 15:43:57', '2020-10-23 10:50:28', '系统管理', '1', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (2, '/system/user', 'user', NULL, NULL, 'views/system/user', 1, 222, '2020-10-16 16:55:46', '2020-10-20 17:36:57', '用户管理', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (3, '/system/role', 'role', NULL, NULL, 'views/system/role', 1, 223, '2020-10-16 16:57:10', '2020-10-20 17:37:02', '角色管理', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (4, '/system/menu', 'menu', NULL, NULL, 'views/system/menu', 1, 224, '2020-10-16 17:06:23', '2020-10-20 17:37:07', '菜单管理', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (5, '/system/data/dict', 'dataDict', NULL, NULL, 'views/system/dataDict', 1, 225, '2020-10-16 11:36:38', '2020-11-24 09:37:44', '数据字典', '2', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES (6, NULL, NULL, 'user:add', NULL, NULL, 2, 777, '2020-10-16 16:56:27', NULL, '用户添加', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (7, NULL, NULL, 'user:edit', NULL, NULL, 2, 778, '2020-10-16 16:56:32', NULL, '用户编辑', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (8, NULL, NULL, 'user:delete', NULL, NULL, 2, 779, '2020-10-16 16:56:37', NULL, '用户删除', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (9, NULL, NULL, NULL, 'el-icon-view', NULL, -1, 3, '2020-10-16 15:44:02', '2020-10-23 10:53:56', '系统监控', '1', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (11, NULL, NULL, 'role:add', NULL, NULL, 3, 777, '2020-10-16 16:57:55', '2020-10-16 11:24:22', '角色添加', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (14, NULL, NULL, 'role:edit', NULL, NULL, 3, 778, '2020-10-16 17:04:26', '2020-10-16 17:04:26', '角色编辑', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (17, NULL, NULL, 'role:delete', NULL, NULL, 3, 779, '2020-10-16 17:05:38', '2020-10-16 17:05:38', '角色删除', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (20, NULL, NULL, 'menu:add', NULL, NULL, 4, 777, '2020-10-19 11:08:00', '2020-10-19 11:08:00', '菜单添加', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (21, NULL, NULL, 'menu:edit', NULL, NULL, 4, 778, '2020-10-19 11:15:01', '2020-11-24 10:38:22', '菜单修改', '3', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES (22, NULL, NULL, 'menu:delete', NULL, NULL, 4, 779, '2020-10-20 10:46:14', '2020-10-20 10:45:54', '菜单删除', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (23, '/monitor/sql', 'sql', NULL, NULL, 'views/monitor/sql', 9, 333, '2020-10-20 11:07:09', '2020-10-21 14:06:35', 'SQL监控', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (24, '/monitor/log', 'log', NULL, NULL, 'views/monitor/log', 9, 334, '2020-10-20 11:16:41', '2020-10-20 17:37:26', '系统日志', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (25, '/monitor/interface', 'interface', NULL, NULL, 'views/monitor/interface', 9, 335, '2020-10-20 11:21:28', '2020-10-20 17:37:31', '接口文档', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (27, NULL, NULL, 'user:role', NULL, NULL, 2, 780, '2020-10-23 18:00:55', '2020-10-24 20:06:08', '分配角色', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (28, NULL, NULL, 'role:menu', NULL, NULL, 3, 780, '2020-10-23 18:08:12', '2020-10-23 18:12:04', '分配菜单', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (30, '/system/dep', 'dep', NULL, NULL, 'views/system/dep', 1, 111, '2020-10-30 17:28:37', '2020-10-30 17:28:37', '部门管理', '2', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (31, NULL, NULL, 'dep:add', NULL, NULL, 30, 777, '2020-11-01 19:09:59', '2020-11-01 19:10:55', '部门添加', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (32, NULL, NULL, 'dep:edit', NULL, NULL, 30, 778, '2020-11-01 19:11:31', '2020-11-02 16:19:00', '部门修改', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (33, NULL, NULL, 'dep:delete', NULL, NULL, 30, 779, '2020-11-01 19:12:06', '2020-11-02 16:19:08', '部门删除', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (34, NULL, NULL, 'dep:user', NULL, NULL, 30, 780, '2020-11-02 16:18:10', '2020-11-02 16:18:43', '分配用户', '3', 'admin', NULL);
INSERT INTO `sys_menu` VALUES (39, NULL, NULL, 'dict:add', NULL, NULL, 5, 777, '2020-11-24 10:38:00', '2020-11-24 10:38:41', '数据字典添加', '3', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES (40, NULL, NULL, 'dict:edit', NULL, NULL, 5, 778, '2020-11-24 10:40:04', '2020-11-24 10:40:04', '数据字典编辑', '3', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES (41, NULL, NULL, 'dict:delete', NULL, NULL, 5, 779, '2020-11-24 10:40:49', '2020-11-24 10:40:49', '数据字典删除', '3', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', '2020-09-17 13:33:03', '2020-11-18 15:03:15', 'admin', NULL);
INSERT INTO `sys_role` VALUES (2, 'member', '系统成员', '2020-10-12 11:50:16', '2020-11-23 17:34:16', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` bigint(20) NULL DEFAULT NULL COMMENT '角色编号',
  `mid` bigint(20) NULL DEFAULT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 209 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (150, 2, 1);
INSERT INTO `sys_role_menu` VALUES (151, 2, 30);
INSERT INTO `sys_role_menu` VALUES (152, 2, 2);
INSERT INTO `sys_role_menu` VALUES (153, 2, 3);
INSERT INTO `sys_role_menu` VALUES (154, 2, 4);
INSERT INTO `sys_role_menu` VALUES (155, 2, 5);
INSERT INTO `sys_role_menu` VALUES (181, 1, 1);
INSERT INTO `sys_role_menu` VALUES (182, 1, 30);
INSERT INTO `sys_role_menu` VALUES (183, 1, 31);
INSERT INTO `sys_role_menu` VALUES (184, 1, 32);
INSERT INTO `sys_role_menu` VALUES (185, 1, 33);
INSERT INTO `sys_role_menu` VALUES (186, 1, 34);
INSERT INTO `sys_role_menu` VALUES (187, 1, 2);
INSERT INTO `sys_role_menu` VALUES (188, 1, 6);
INSERT INTO `sys_role_menu` VALUES (189, 1, 7);
INSERT INTO `sys_role_menu` VALUES (190, 1, 8);
INSERT INTO `sys_role_menu` VALUES (191, 1, 27);
INSERT INTO `sys_role_menu` VALUES (192, 1, 3);
INSERT INTO `sys_role_menu` VALUES (193, 1, 11);
INSERT INTO `sys_role_menu` VALUES (194, 1, 14);
INSERT INTO `sys_role_menu` VALUES (195, 1, 17);
INSERT INTO `sys_role_menu` VALUES (196, 1, 28);
INSERT INTO `sys_role_menu` VALUES (197, 1, 4);
INSERT INTO `sys_role_menu` VALUES (198, 1, 20);
INSERT INTO `sys_role_menu` VALUES (199, 1, 21);
INSERT INTO `sys_role_menu` VALUES (200, 1, 22);
INSERT INTO `sys_role_menu` VALUES (201, 1, 5);
INSERT INTO `sys_role_menu` VALUES (202, 1, 39);
INSERT INTO `sys_role_menu` VALUES (203, 1, 40);
INSERT INTO `sys_role_menu` VALUES (204, 1, 41);
INSERT INTO `sys_role_menu` VALUES (205, 1, 9);
INSERT INTO `sys_role_menu` VALUES (206, 1, 23);
INSERT INTO `sys_role_menu` VALUES (207, 1, 24);
INSERT INTO `sys_role_menu` VALUES (208, 1, 25);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `enable` tinyint(5) NULL DEFAULT NULL COMMENT '是否启用',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'c87786626c309e4bda28a5d06ef71aab', 'eWrjErrosi9X9H/6wv8WFg==', 'admin@boot.com', '管理员', '2020-09-16 10:15:14', '2020-10-24 14:34:13', '13170072060', 1, 'admin', NULL);
INSERT INTO `sys_user` VALUES (2, 'test', '29620b0d687aa74d5ee390c78886fd61', 'wkt/YpURlzZ+dqVBMy9YRQ==', 'test@boot.com', '测试用户', '2020-10-10 10:58:42', '2020-11-25 10:16:34', '13170072060', 0, 'admin', 'admin');
INSERT INTO `sys_user` VALUES (3, 'dev', '0ad2ecc65d3532731b8f768f024ecda2', 'an0her4dqTWiVQJDIwSDRA==', 'dev@boot.com', '开发人员', '2020-09-16 12:06:52', '2020-10-29 11:22:14', '45369875', 1, 'admin', NULL);
INSERT INTO `sys_user` VALUES (8, 'test2', '1d87dc8f9223b44a807ca8d7f7367d8b', '3N3giOCcU/iX7hZXVLl3ZA==', 'test2@zboot', 'test2a', '2020-10-24 20:30:20', '2020-10-29 14:12:18', '1256895', 1, 'admin', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `rid` bigint(20) NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 2, 2);
INSERT INTO `sys_user_role` VALUES (7, 5, 2);
INSERT INTO `sys_user_role` VALUES (9, 1, 1);
INSERT INTO `sys_user_role` VALUES (10, 3, 2);
INSERT INTO `sys_user_role` VALUES (11, 8, 2);

SET FOREIGN_KEY_CHECKS = 1;
