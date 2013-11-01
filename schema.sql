
    alter table address 
        drop 
        foreign key FKBB979BF4D4F0CB6D

    alter table user_role 
        drop 
        foreign key FK143BF46A33D412D2

    alter table user_role 
        drop 
        foreign key FK143BF46AF5FDD722

    drop table if exists address

    drop table if exists mylog

    drop table if exists role

    drop table if exists user

    drop table if exists user_role

    create table address (
        country varchar(255),
        roomNumber integer not null,
        state varchar(255),
        streetAddr varchar(255),
        streetAddr2 varchar(255),
        user_username varchar(255) not null,
        primary key (user_username)
    )

    create table mylog (
        id integer not null auto_increment,
        info varchar(255),
        primary key (id)
    )

    create table role (
        id integer not null auto_increment,
        roleName varchar(255),
        primary key (id)
    )

    create table user (
        username varchar(255) not null,
        email varchar(255),
        firstName varchar(255),
        lastName varchar(255),
        middleName varchar(255),
        password varchar(255),
        primary key (username)
    )

    create table user_role (
        role_id integer not null,
        user_name varchar(255) not null,
        primary key (role_id, user_name)
    )

    alter table address 
        add index FKBB979BF4D4F0CB6D (user_username), 
        add constraint FKBB979BF4D4F0CB6D 
        foreign key (user_username) 
        references user (username)

    alter table user_role 
        add index FK143BF46A33D412D2 (role_id), 
        add constraint FK143BF46A33D412D2 
        foreign key (role_id) 
        references role (id)

    alter table user_role 
        add index FK143BF46AF5FDD722 (user_name), 
        add constraint FK143BF46AF5FDD722 
        foreign key (user_name) 
        references user (username)
