--初始化role
insert into roles values ('1','管理员','ROLE_ADMIN');
insert into roles values ('2','普通用户','ROLE_USER');
insert into roles values ('3','a','ROLE_A');

--初始化user
insert into user_info (password, username, uid) values ('$2a$10$j0T8C80mrdtDx5I1UL85teUtMY2/23UEb7kR5toVcvnbSqpsubgme','a','1');
insert into user_info (password, username, uid) values ('$2a$10$j0T8C80mrdtDx5I1UL85teUtMY2/23UEb7kR5toVcvnbSqpsubgme','u','2');
insert into user_info (password, username, uid) values ('$2a$10$j0T8C80mrdtDx5I1UL85teUtMY2/23UEb7kR5toVcvnbSqpsubgme','b','3');

--初始化user_role
insert into user_role values ('1','1');
insert into user_role values ('2','2');
insert into user_role values ('3','3');

--初始化permission
insert into permission values ('1','/admin');
insert into permission values ('2','/user');
insert into permission values ('3','/a');
insert into permission values ('4','/index');
insert into permission values ('5','/b');

--初始化permission_role
insert into permission_role values ('1','1');
insert into permission_role values ('2','1');
insert into permission_role values ('3','1');
insert into permission_role values ('4','1');
insert into permission_role values ('2','2');
insert into permission_role values ('3','2');
insert into permission_role values ('4','2');
insert into permission_role values ('3','3');
insert into permission_role values ('4','3');
insert into permission_role values ('5','2');












