CREATE TABLE reimbursement_status(
    reimb_status_id number not null constraint reimb_status_pk primary key,
    reimb_status varchar2(10) not null
);

CREATE TABLE reimbursement_type(
    reimb_type_id number not null constraint reimb_type_pk primary key,
    reimb_type varchar2(10) not null
);

CREATE TABLE user_roles(
    ers_user_role_id number not null constraint ers_user_roles_pk primary key,
    user_role varchar2(10) not null
);

CREATE TABLE users(
    ers_users_id Number not null constraint ers_users_pk primary key,
    ers_username varchar2(50) unique not null,
    ers_password varchar2(50) not null,
    user_first_name varchar2(100) not null,
    user_last_name varchar2(100) not null,
    user_email varchar2(150) unique not null,
    user_role_id Number constraint user_roles_fk references user_roles not null
    
);

CREATE TABLE reimbursement(
    reimb_id Number not null constraint ers_reimbursement_pk primary key,
    reimb_amount Number(8,2) not null,
    reimb_submitted timestamp default current_timestamp not null,
    reimb_resolved timestamp,
    reimb_description varchar2(250),
    reimb_receipt blob,
    reimb_author Number constraint ers_users_fk_auth references users not null,
    reimb_resolver Number constraint ers_users_fk_reslvr references users,
    reimb_status_id Number constraint ers_reimbursement_status_fk references reimbursement_status not null,
    reimb_type_id Number constraint ers_reimbursement_type_fk references reimbursement_type not null
);
commit;

insert into user_roles values(0, 'admin');
insert into users values(1,'yeet','boom','bob','sagget','boomman',0);
insert into users values(2,'yeet@gmail.com','boom','bob','sagget','boomma',0);
insert into users values(3,'yah@gmail.com','boom','bob','sagget','boomm',1);
insert into reimbursement_status values(1, 'resolved');

insert into reimbursement(reimb_id,reimb_amount, values(1, 10.56, 


insert into reimbursement_type values(3, 'OTHER');
commit;
exit;

SELECT * FROM Users WHERE ers_username = 'yeet@gmail.com' AND ers_password = 'boom';