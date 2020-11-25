


-- ----------------------------
-- Table structure for sys_data_dict
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_data_dict";
CREATE TABLE "public"."sys_data_dict" (
  "id" int8 NOT NULL,
  "dict_name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_data_dict"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_data_dict"."dict_name" IS '数据字典名称';
COMMENT ON COLUMN "public"."sys_data_dict"."description" IS '描述';
COMMENT ON COLUMN "public"."sys_data_dict"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_data_dict"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_data_dict"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."sys_data_dict"."update_by" IS '更新人';
COMMENT ON TABLE "public"."sys_data_dict" IS '数据字典';

-- ----------------------------
-- Records of sys_data_dict
-- ----------------------------
INSERT INTO "public"."sys_data_dict" VALUES (1, 'sys', '系统简写', '2020-11-24 10:42:13', '2020-11-24 10:42:25', 'admin', 'admin');
INSERT INTO "public"."sys_data_dict" VALUES (2, 'dep', '部门简写', '2020-11-24 10:45:17', '2020-11-24 10:45:17', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_dep
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dep";
CREATE TABLE "public"."sys_dep" (
  "id" int8 NOT NULL,
  "parent_id" int8,
  "department_name" varchar(255) COLLATE "pg_catalog"."default",
  "sort" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_dep"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_dep"."parent_id" IS '父节点';
COMMENT ON COLUMN "public"."sys_dep"."department_name" IS '部门名称';
COMMENT ON COLUMN "public"."sys_dep"."sort" IS '排序';
COMMENT ON COLUMN "public"."sys_dep"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_dep"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_dep"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."sys_dep"."update_by" IS '更新人';
COMMENT ON TABLE "public"."sys_dep" IS '部门表';

-- ----------------------------
-- Records of sys_dep
-- ----------------------------
INSERT INTO "public"."sys_dep" VALUES (1, -1, '研发部', 1, '2020-10-30 16:02:27', '2020-11-16 11:24:15', 'admin', NULL);
INSERT INTO "public"."sys_dep" VALUES (2, -1, '测试部', 2, '2020-10-30 16:02:29', '2020-11-23 16:11:44', 'admin', NULL);
INSERT INTO "public"."sys_dep" VALUES (3, 1, '研发大队', 1, '2020-11-01 16:48:23', '2020-11-23 17:10:03', 'admin', 'admin');
INSERT INTO "public"."sys_dep" VALUES (4, 2, '测试小分队', 4, '2020-11-01 17:18:20', '2020-11-01 19:20:17', 'admin', NULL);
INSERT INTO "public"."sys_dep" VALUES (8, 1, '研发2队', 6, '2020-11-02 14:28:17', '2020-11-18 13:43:29', 'admin', NULL);
INSERT INTO "public"."sys_dep" VALUES (9, 1, '研发副队', 3, '2020-11-23 17:11:11', '2020-11-23 17:11:11', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_dep_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_dep_user";
CREATE TABLE "public"."sys_dep_user" (
  "id" int8 NOT NULL,
  "dep_id" int8,
  "user_id" int8
)
;
COMMENT ON COLUMN "public"."sys_dep_user"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_dep_user"."dep_id" IS '部门编号';
COMMENT ON COLUMN "public"."sys_dep_user"."user_id" IS '用户编号';
COMMENT ON TABLE "public"."sys_dep_user" IS '部门用户关联表';

-- ----------------------------
-- Records of sys_dep_user
-- ----------------------------
INSERT INTO "public"."sys_dep_user" VALUES (1, 3, 1);
INSERT INTO "public"."sys_dep_user" VALUES (3, 4, 8);
INSERT INTO "public"."sys_dep_user" VALUES (5, 8, 2);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_log";
CREATE TABLE "public"."sys_log" (
  "id" int8 NOT NULL,
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "ipaddress" varchar(255) COLLATE "pg_catalog"."default",
  "oprator" varchar(255) COLLATE "pg_catalog"."default",
  "usage_time" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_log"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_log"."username" IS '用户名';
COMMENT ON COLUMN "public"."sys_log"."ipaddress" IS 'ip地址';
COMMENT ON COLUMN "public"."sys_log"."oprator" IS '操作';
COMMENT ON COLUMN "public"."sys_log"."usage_time" IS '耗时';
COMMENT ON COLUMN "public"."sys_log"."create_time" IS '创建时间';
COMMENT ON TABLE "public"."sys_log" IS '系统日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO "public"."sys_log" VALUES (4051, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-23 17:08:47');
INSERT INTO "public"."sys_log" VALUES (4052, 'admin', '0:0:0:0:0:0:0:1', '更新:修改部门', '24', '2020-11-23 17:10:03');
INSERT INTO "public"."sys_log" VALUES (4053, 'admin', '0:0:0:0:0:0:0:1', '添加:添加部门', '15', '2020-11-23 17:11:11');
INSERT INTO "public"."sys_log" VALUES (4054, 'admin', '0:0:0:0:0:0:0:1', '删除:修改角色', '18', '2020-11-23 17:34:16');
INSERT INTO "public"."sys_log" VALUES (4055, 'admin', '127.0.0.1', '用户登陆', '1', '2020-11-24 09:32:54');
INSERT INTO "public"."sys_log" VALUES (4056, 'admin', '0:0:0:0:0:0:0:1', '添加:添加菜单', '9', '2020-11-24 10:38:00');
INSERT INTO "public"."sys_log" VALUES (4057, 'admin', '0:0:0:0:0:0:0:1', '添加:添加菜单', '9', '2020-11-24 10:40:04');
INSERT INTO "public"."sys_log" VALUES (4058, 'admin', '0:0:0:0:0:0:0:1', '添加:添加菜单', '8', '2020-11-24 10:40:49');
INSERT INTO "public"."sys_log" VALUES (4059, 'admin', '0:0:0:0:0:0:0:1', '更新:添加修改菜单权限', '12', '2020-11-24 10:41:08');
INSERT INTO "public"."sys_log" VALUES (4060, 'admin', '0:0:0:0:0:0:0:1', '添加:添加数据字典', '8', '2020-11-24 10:42:13');
INSERT INTO "public"."sys_log" VALUES (4061, 'admin', '0:0:0:0:0:0:0:1', '更新:修改数据字典', '9', '2020-11-24 10:42:25');
INSERT INTO "public"."sys_log" VALUES (4062, 'admin', '0:0:0:0:0:0:0:1', '添加:添加数据字典', '17', '2020-11-24 10:45:17');
INSERT INTO "public"."sys_log" VALUES (4063, 'admin', '0:0:0:0:0:0:0:1', '添加:添加数据字典', '17', '2020-11-24 10:54:08');
INSERT INTO "public"."sys_log" VALUES (4064, 'admin', '0:0:0:0:0:0:0:1', '删除:删除数据字典', '10', '2020-11-24 10:54:11');
INSERT INTO "public"."sys_log" VALUES (4065, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 10:58:43');
INSERT INTO "public"."sys_log" VALUES (4066, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 11:59:25');
INSERT INTO "public"."sys_log" VALUES (4067, 'test', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 13:40:04');
INSERT INTO "public"."sys_log" VALUES (4068, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-24 13:41:04');
INSERT INTO "public"."sys_log" VALUES (4069, 'admin', '0:0:0:0:0:0:0:1', '用户登陆', '1', '2020-11-25 08:56:22');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_menu";
CREATE TABLE "public"."sys_menu" (
  "id" int8 NOT NULL,
  "path" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "permission" varchar(255) COLLATE "pg_catalog"."default",
  "icon_cls" varchar(255) COLLATE "pg_catalog"."default",
  "component" varchar(255) COLLATE "pg_catalog"."default",
  "parent_id" int8 NOT NULL,
  "sort" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "title" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "type" varchar(32) COLLATE "pg_catalog"."default",
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_menu"."id" IS '菜单编号';
COMMENT ON COLUMN "public"."sys_menu"."path" IS '菜单路径';
COMMENT ON COLUMN "public"."sys_menu"."name" IS '菜单名称';
COMMENT ON COLUMN "public"."sys_menu"."permission" IS '菜单权限';
COMMENT ON COLUMN "public"."sys_menu"."icon_cls" IS '菜单图标';
COMMENT ON COLUMN "public"."sys_menu"."component" IS '菜单组件';
COMMENT ON COLUMN "public"."sys_menu"."parent_id" IS '父节点';
COMMENT ON COLUMN "public"."sys_menu"."sort" IS '排序';
COMMENT ON COLUMN "public"."sys_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_menu"."title" IS '标题';
COMMENT ON COLUMN "public"."sys_menu"."type" IS '菜单类型（1目录，2菜单，3按钮）';
COMMENT ON COLUMN "public"."sys_menu"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."sys_menu"."update_by" IS '更新人';
COMMENT ON TABLE "public"."sys_menu" IS '菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "public"."sys_menu" VALUES (1, NULL, '', NULL, 'el-icon-setting', NULL, -1, 2, '2020-10-16 15:43:57', '2020-10-23 10:50:28', '系统管理', '1', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (2, '/system/user', 'user', NULL, NULL, 'views/system/user', 1, 222, '2020-10-16 16:55:46', '2020-10-20 17:36:57', '用户管理', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (3, '/system/role', 'role', NULL, NULL, 'views/system/role', 1, 223, '2020-10-16 16:57:10', '2020-10-20 17:37:02', '角色管理', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (4, '/system/menu', 'menu', NULL, NULL, 'views/system/menu', 1, 224, '2020-10-16 17:06:23', '2020-10-20 17:37:07', '菜单管理', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (5, '/system/data/dict', 'dataDict', NULL, NULL, 'views/system/dataDict', 1, 225, '2020-10-16 11:36:38', '2020-11-24 09:37:44', '数据字典', '2', 'admin', 'admin');
INSERT INTO "public"."sys_menu" VALUES (6, NULL, NULL, 'user:add', NULL, NULL, 2, 777, '2020-10-16 16:56:27', NULL, '用户添加', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (7, NULL, NULL, 'user:edit', NULL, NULL, 2, 778, '2020-10-16 16:56:32', NULL, '用户编辑', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (8, NULL, NULL, 'user:delete', NULL, NULL, 2, 779, '2020-10-16 16:56:37', NULL, '用户删除', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (9, NULL, NULL, NULL, 'el-icon-view', NULL, -1, 3, '2020-10-16 15:44:02', '2020-10-23 10:53:56', '系统监控', '1', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (11, NULL, NULL, 'role:add', NULL, NULL, 3, 777, '2020-10-16 16:57:55', '2020-10-16 11:24:22', '角色添加', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (14, NULL, NULL, 'role:edit', NULL, NULL, 3, 778, '2020-10-16 17:04:26', '2020-10-16 17:04:26', '角色编辑', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (17, NULL, NULL, 'role:delete', NULL, NULL, 3, 779, '2020-10-16 17:05:38', '2020-10-16 17:05:38', '角色删除', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (20, NULL, NULL, 'menu:add', NULL, NULL, 4, 777, '2020-10-19 11:08:00', '2020-10-19 11:08:00', '菜单添加', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (21, NULL, NULL, 'menu:edit', NULL, NULL, 4, 778, '2020-10-19 11:15:01', '2020-11-24 10:38:22', '菜单修改', '3', 'admin', 'admin');
INSERT INTO "public"."sys_menu" VALUES (22, NULL, NULL, 'menu:delete', NULL, NULL, 4, 779, '2020-10-20 10:46:14', '2020-10-20 10:45:54', '菜单删除', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (23, '/monitor/sql', 'sql', NULL, NULL, 'views/monitor/sql', 9, 333, '2020-10-20 11:07:09', '2020-10-21 14:06:35', 'SQL监控', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (24, '/monitor/log', 'log', NULL, NULL, 'views/monitor/log', 9, 334, '2020-10-20 11:16:41', '2020-10-20 17:37:26', '系统日志', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (25, '/monitor/interface', 'interface', NULL, NULL, 'views/monitor/interface', 9, 335, '2020-10-20 11:21:28', '2020-10-20 17:37:31', '接口文档', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (27, NULL, NULL, 'user:role', NULL, NULL, 2, 780, '2020-10-23 18:00:55', '2020-10-24 20:06:08', '分配角色', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (28, NULL, NULL, 'role:menu', NULL, NULL, 3, 780, '2020-10-23 18:08:12', '2020-10-23 18:12:04', '分配菜单', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (30, '/system/dep', 'dep', NULL, NULL, 'views/system/dep', 1, 111, '2020-10-30 17:28:37', '2020-10-30 17:28:37', '部门管理', '2', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (31, NULL, NULL, 'dep:add', NULL, NULL, 30, 777, '2020-11-01 19:09:59', '2020-11-01 19:10:55', '部门添加', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (32, NULL, NULL, 'dep:edit', NULL, NULL, 30, 778, '2020-11-01 19:11:31', '2020-11-02 16:19:00', '部门修改', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (33, NULL, NULL, 'dep:delete', NULL, NULL, 30, 779, '2020-11-01 19:12:06', '2020-11-02 16:19:08', '部门删除', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (34, NULL, NULL, 'dep:user', NULL, NULL, 30, 780, '2020-11-02 16:18:10', '2020-11-02 16:18:43', '分配用户', '3', 'admin', NULL);
INSERT INTO "public"."sys_menu" VALUES (39, NULL, NULL, 'dict:add', NULL, NULL, 5, 777, '2020-11-24 10:38:00', '2020-11-24 10:38:41', '数据字典添加', '3', 'admin', 'admin');
INSERT INTO "public"."sys_menu" VALUES (40, NULL, NULL, 'dict:edit', NULL, NULL, 5, 778, '2020-11-24 10:40:04', '2020-11-24 10:40:04', '数据字典编辑', '3', 'admin', 'admin');
INSERT INTO "public"."sys_menu" VALUES (41, NULL, NULL, 'dict:delete', NULL, NULL, 5, 779, '2020-11-24 10:40:49', '2020-11-24 10:40:49', '数据字典删除', '3', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
  "id" int8 NOT NULL,
  "role_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_role"."id" IS '角色编号';
COMMENT ON COLUMN "public"."sys_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."description" IS '角色描述';
COMMENT ON COLUMN "public"."sys_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_role"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."sys_role"."update_by" IS '更新人';
COMMENT ON TABLE "public"."sys_role" IS '角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES (1, 'admin', '超级管理员', '2020-09-17 13:33:03', '2020-11-18 15:03:15', 'admin', NULL);
INSERT INTO "public"."sys_role" VALUES (2, 'member', '系统成员', '2020-10-12 11:50:16', '2020-11-23 17:34:16', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_menu";
CREATE TABLE "public"."sys_role_menu" (
  "id" int8 NOT NULL,
  "rid" int8,
  "mid" int8
)
;
COMMENT ON COLUMN "public"."sys_role_menu"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_role_menu"."rid" IS '角色编号';
COMMENT ON COLUMN "public"."sys_role_menu"."mid" IS '菜单编号';
COMMENT ON TABLE "public"."sys_role_menu" IS '角色菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO "public"."sys_role_menu" VALUES (150, 2, 1);
INSERT INTO "public"."sys_role_menu" VALUES (151, 2, 30);
INSERT INTO "public"."sys_role_menu" VALUES (152, 2, 2);
INSERT INTO "public"."sys_role_menu" VALUES (153, 2, 3);
INSERT INTO "public"."sys_role_menu" VALUES (154, 2, 4);
INSERT INTO "public"."sys_role_menu" VALUES (155, 2, 5);
INSERT INTO "public"."sys_role_menu" VALUES (181, 1, 1);
INSERT INTO "public"."sys_role_menu" VALUES (182, 1, 30);
INSERT INTO "public"."sys_role_menu" VALUES (183, 1, 31);
INSERT INTO "public"."sys_role_menu" VALUES (184, 1, 32);
INSERT INTO "public"."sys_role_menu" VALUES (185, 1, 33);
INSERT INTO "public"."sys_role_menu" VALUES (186, 1, 34);
INSERT INTO "public"."sys_role_menu" VALUES (187, 1, 2);
INSERT INTO "public"."sys_role_menu" VALUES (188, 1, 6);
INSERT INTO "public"."sys_role_menu" VALUES (189, 1, 7);
INSERT INTO "public"."sys_role_menu" VALUES (190, 1, 8);
INSERT INTO "public"."sys_role_menu" VALUES (191, 1, 27);
INSERT INTO "public"."sys_role_menu" VALUES (192, 1, 3);
INSERT INTO "public"."sys_role_menu" VALUES (193, 1, 11);
INSERT INTO "public"."sys_role_menu" VALUES (194, 1, 14);
INSERT INTO "public"."sys_role_menu" VALUES (195, 1, 17);
INSERT INTO "public"."sys_role_menu" VALUES (196, 1, 28);
INSERT INTO "public"."sys_role_menu" VALUES (197, 1, 4);
INSERT INTO "public"."sys_role_menu" VALUES (198, 1, 20);
INSERT INTO "public"."sys_role_menu" VALUES (199, 1, 21);
INSERT INTO "public"."sys_role_menu" VALUES (200, 1, 22);
INSERT INTO "public"."sys_role_menu" VALUES (201, 1, 5);
INSERT INTO "public"."sys_role_menu" VALUES (202, 1, 39);
INSERT INTO "public"."sys_role_menu" VALUES (203, 1, 40);
INSERT INTO "public"."sys_role_menu" VALUES (204, 1, 41);
INSERT INTO "public"."sys_role_menu" VALUES (205, 1, 9);
INSERT INTO "public"."sys_role_menu" VALUES (206, 1, 23);
INSERT INTO "public"."sys_role_menu" VALUES (207, 1, 24);
INSERT INTO "public"."sys_role_menu" VALUES (208, 1, 25);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
  "id" int8 NOT NULL,
  "username" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "salt" varchar(255) COLLATE "pg_catalog"."default",
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "telephone" varchar(255) COLLATE "pg_catalog"."default",
  "enable" varchar(5) COLLATE "pg_catalog"."default",
  "create_by" varchar(255) COLLATE "pg_catalog"."default",
  "update_by" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."sys_user"."id" IS '用户编号';
COMMENT ON COLUMN "public"."sys_user"."username" IS '用户名称';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."salt" IS '盐值';
COMMENT ON COLUMN "public"."sys_user"."email" IS '邮箱';
COMMENT ON COLUMN "public"."sys_user"."name" IS '名称';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."sys_user"."telephone" IS '电话';
COMMENT ON COLUMN "public"."sys_user"."enable" IS '是否启用';
COMMENT ON COLUMN "public"."sys_user"."create_by" IS '创建人';
COMMENT ON COLUMN "public"."sys_user"."update_by" IS '更新人';
COMMENT ON TABLE "public"."sys_user" IS '用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES (1, 'admin', 'c87786626c309e4bda28a5d06ef71aab', 'eWrjErrosi9X9H/6wv8WFg==', 'admin@boot.com', '管理员', '2020-09-16 10:15:14', '2020-10-24 14:34:13', '13170072060', 't', 'admin', NULL);
INSERT INTO "public"."sys_user" VALUES (2, 'test', '29620b0d687aa74d5ee390c78886fd61', 'wkt/YpURlzZ+dqVBMy9YRQ==', 'test@boot.com', '测试用户', '2020-10-10 10:58:42', '2020-09-16 10:25:14', '13170072060', 't', 'admin', NULL);
INSERT INTO "public"."sys_user" VALUES (3, 'dev', '0ad2ecc65d3532731b8f768f024ecda2', 'an0her4dqTWiVQJDIwSDRA==', 'dev@boot.com', '开发人员', '2020-09-16 12:06:52', '2020-10-29 11:22:14', '45369875', 'f', 'admin', NULL);
INSERT INTO "public"."sys_user" VALUES (8, 'test2', '1d87dc8f9223b44a807ca8d7f7367d8b', '3N3giOCcU/iX7hZXVLl3ZA==', 'test2@zboot', 'test2a', '2020-10-24 20:30:20', '2020-10-29 14:12:18', '1256895', 'f', 'admin', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
  "id" int8 NOT NULL,
  "uid" int8,
  "rid" int8
)
;
COMMENT ON COLUMN "public"."sys_user_role"."id" IS '主键';
COMMENT ON COLUMN "public"."sys_user_role"."uid" IS '用户编号';
COMMENT ON COLUMN "public"."sys_user_role"."rid" IS '角色编号';
COMMENT ON TABLE "public"."sys_user_role" IS '用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO "public"."sys_user_role" VALUES (2, 2, 2);
INSERT INTO "public"."sys_user_role" VALUES (7, 5, 2);
INSERT INTO "public"."sys_user_role" VALUES (9, 1, 1);
INSERT INTO "public"."sys_user_role" VALUES (10, 3, 2);
INSERT INTO "public"."sys_user_role" VALUES (11, 8, 2);

-- ----------------------------
-- Primary Key structure for table sys_dep
-- ----------------------------
ALTER TABLE "public"."sys_dep" ADD CONSTRAINT "sys_dep_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_dep_user
-- ----------------------------
ALTER TABLE "public"."sys_dep_user" ADD CONSTRAINT "sys_dep_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_log
-- ----------------------------
ALTER TABLE "public"."sys_log" ADD CONSTRAINT "sys_log_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "public"."sys_menu" ADD CONSTRAINT "sys_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "public"."sys_role_menu" ADD CONSTRAINT "sys_role_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD CONSTRAINT "sys_user_role_pkey" PRIMARY KEY ("id");
