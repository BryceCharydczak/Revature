-- Banking App SQL Tables

CREATE TABLE Users(
    ID Number(20) constraint pk_user primary key,
    username varchar2(20) not null,
    pass varchar2(20) not null
);
commit;

drop table users;
commit;

CREATE TABLE Accounts(
    ID Number(20) constraint pk_account primary key,
    userID Number(20)
    Constraint fk_user
        references users,
    balance Number(8,2) not null
);
commit;

drop table accounts;
commit;

insert into  users (username, pass) values('Bryce', 'Charydczak');

select * from users;
--Auto Increment trigger for users
CREATE SEQUENCE accounts_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;


--dropping old sequence
drop sequence users_seq;
commit;

CREATE OR REPLACE TRIGGER accounts_trigger 
BEFORE INSERT ON accounts
FOR EACH ROW

BEGIN
  SELECT accounts_seq.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/
commit;


--User primary key trigger
CREATE SEQUENCE users_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;


--dropping old sequence
drop sequence users_seq;
commit;

CREATE OR REPLACE TRIGGER users_trigger 
BEFORE INSERT ON users
FOR EACH ROW

BEGIN
  SELECT users_seq.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/
drop sequence users_seq;
drop sequence accounts_seq;
drop trigger users_trigger;
drop trigger accounts_trigger;
select * from users;
select * from accounts;
insert into accounts(userid) values(0);
