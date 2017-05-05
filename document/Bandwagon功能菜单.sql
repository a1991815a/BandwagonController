-- ---------------------------------------------------
-- Bandwagon
-- ---------------------------------------------------


truncate table FMR_MENU;
insert into FMR_MENU (PARENT_CODE, MENU_CODE, MENU_NAME, MENU_LEVEL, MENU_STATUS,MENU_TYPE,MENU_ICON,MENU_URL,MENU_TARGET) values ('ROOT', 'MENU', '系统根菜单', 0, 0, 0, 'null', 'null', 'null');
commit;

-- ---------------------------------------------------
-- Bandwagon创建完成
-- ---------------------------------------------------
