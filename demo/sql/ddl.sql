use maple;

create table character_basic
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

alter table character_basic drop primary key, add primary key(id, ocid);

-- 테스트
insert into character_basic (
    ocid,
    date,
    character_name,
    world_name,
    character_gender,
    character_class,
    character_class_level,
    character_level,
    character_exp,
    character_exp_rate,
    character_guild_name,
    character_image
) values (
             'ch_ocid',
             'test',
             'chracter_basic',
             'test',
             'M',
             'test',
             '5',
             1,
             2,
             'chract',
             'test',
             'chracter_basic'
         )

----------------------------------------------------------

create table character_popularity
(
    ocid varchar(35),
    date varchar(25),
    popularity BIGINT,
    primary key (ocid)
);

alter table character_popularity add primary key(ocid);

----------------------------------------------------------
create table ranking_overall
(
    id bigint auto_increment,
    ocid varchar(35),
    date varchar(25),
    world_name varchar(20),
    ranking BIGINT,
    character_name varchar(50),
    character_level BIGINT,
    character_exp BIGINT,
    class_name varchar(30),
    sub_class_name varchar(30),
    character_popularity varchar(30),
    character_guildname varchar(30),
    primary key (id, ocid)
);

alter table ranking_overall drop primary key, add primary key(id);

insert into ranking_overall
(
    date,
    world_name,
    ranking,
    character_name,
    character_level,
    character_exp,
    class_name,
    sub_class_name,
    character_popularity,
    character_guildname
)
values (
           'tttt',
           'worldname',
           1,
           'test',
           2,
           3,
           'classname',
           'subclassname',
           5,
           'guildname'
       )


