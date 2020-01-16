create table if not exists `student`(
    `id` int (11) primary key auto_increment ,
    `name` varchar (20) not null ,
    `sex` varchar (2) not null ,
    `age` int (11) not null ,
    `class_id` int (11) not null
);