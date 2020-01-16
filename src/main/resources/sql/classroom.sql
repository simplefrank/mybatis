create table if not exists `class` (
    `id` int(11) primary key auto_increment,
    `name` varchar(20) not null
);
insert into `class`(`name`) values ('一年级一班');
insert into `class`(`name`) values ('一年级二班');
insert into `class`(`name`) values ('一年级三班');
insert into `class`(`name`) values ('一年级四班');