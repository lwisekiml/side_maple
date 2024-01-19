create table chracter_basic
(
    id bigint auto_increment,
    ocid varchar(35),
    date varchar(25),
    character_name varchar(50),
    world_name varchar(20),
    character_gender varchar(1),
    character_class varchar(20),
    character_class_level varchar(1),
    character_level BIGINT,
    character_exp BIGINT,
    character_exp_rate varchar(10),
    character_guild_name varchar(20),
    character_image varchar(400),
    primary key (id)
);
