drop table if exists information;
create table `information`(
`id` int(10) not null auto_increment,   -- 资讯id
`title` varchar(30) not null,   -- 资讯标题
`content` varchar(500) not null,-- 资讯内容
`replyCount` int(10) not null,-- 回复次数
`viewCount` int(10) not null,-- 查看次数
`reportTime` date not null,-- 发表时间
`lastPostTime` date not null,-- 最后回复时间
primary key (`id`)
)engine=innodb auto_increment=15 default charset=utf8mb4;

insert into information (id,title,content,replyCount,viewCount,reportTime,lastPostTime) values (1,'iPhone12','电量不够用',2,31,'2020-11-12','2020-11-15');
insert into information (id,title,content,replyCount,viewCount,reportTime,lastPostTime) values (2,'美国大选','特朗普下台',7,141,'2020-11-11','2020-11-13');
insert into information (id,title,content,replyCount,viewCount,reportTime,lastPostTime) values (3,'最新疫情','青岛疫情爆发',2,129,'2020-11-11','2020-11-14');

drop table if exists replies;
create table `replies`(
`id` int(10) not null auto_increment,-- 回复id
`content` varchar(200) not null,-- 回复内容
`replyTime` date not null,-- 回复时间
`infold` int(10) not null,-- 资讯id
primary key (`id`)
)engine=innodb auto_increment=15 default charset=utf8mb4;

insert into replies (id, content, replyTime, infold) values (1,'电量完全不够看','2020-11-14',1);
insert into replies (id, content, replyTime, infold) values (2,'iPhone12好像iPhone5','2020-11-15',1);
insert into replies (id, content, replyTime, infold) values (3,'拜登获选','2020-11-14',2);

alter table replies add constraint fk_information_replies foreign key(infold) references information(id);