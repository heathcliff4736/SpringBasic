CREATE TABLE reply(
                      rno int auto_increment primary key,
                      bno int not null,
                      replyText varchar(2000) not null,
                      replyer varchar(100) not null,
                      regDate timestamp default current_timestamp() null,
                      updateDate timestamp default current_timestamp() null,
                      constraint fk_reply_board foreign key (bno) references board(bno)
);



insert into reply (bno, replyText, replyer) VALUES (1,"댓글1","댓글 작성자1");
insert into reply (bno, replyText, replyer) VALUES (1024,"1024번 글의 첫번째 댓글","댓글맨1");

SELECT * FROM reply;


DESC reply;

SELECT COUNT(*) FROM board;

SELECT * FROM board order by bno desc;