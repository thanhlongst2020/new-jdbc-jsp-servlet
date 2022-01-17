use newservlet12month2018;

insert into role(code,name) values('ADMIN', 'Quản trị');
insert into role(code,name) values('USER', 'Người dùng');

insert into user(username, password, fullname,status, roleid) values('admin','123456','admin',1,1);
insert into user(username, password, fullname,status, roleid) values('nguyenvana','123456','Nguyễn Văn A',1,2);
insert into user(username, password, fullname,status, roleid) values('nguyenvanb','123456','Nguyễn Văn A',1,2);