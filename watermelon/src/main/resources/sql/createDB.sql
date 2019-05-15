create table if not exists `link` (
    `id` integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `long_link` VARCHAR(256) not null,
    `keyword` varchar(24) not null,
    `count` INTEGER not null default 0,
    `create_time` timestamp default current_timestamp,
    `update_time` timestamp default current_timestamp on update current_timestamp,
    index index_id(id)
)ENGINE=InnoDB DEFAULT CHARSET=gbk;