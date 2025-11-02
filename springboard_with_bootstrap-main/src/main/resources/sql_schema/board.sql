use sqldb;

create table board

(
    bno        int auto_increment
        primary key,
    title      varchar(500)                          not null,
    content    varchar(2000)                         not null,
    writer     varchar(100)                          not null,
    regDate    timestamp default current_timestamp() null,
    updateDate timestamp default current_timestamp() null
);

insert into board(title,content,writer) values ("boardTest","boardContent","user00");
select * from board;


# 10000건 더미데이터 입력
insert into board(title,content,writer)
select title,content,writer from board;

select count(*) from board;