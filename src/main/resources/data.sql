DROP TABLE IF EXISTS contacts CASCADE;
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(250) NOT NULL
);

CREATE TABLE contacts
(
    id      int auto_increment primary key,
    name    varchar(50),
    number  varchar(15),
    user_id int
        references users (id) on update no action on delete no action
);

INSERT INTO users (name)
VALUES ('albert einstein'),
       ('bill gates'),
       ('franz kafka');

INSERT INTO contacts (name, number, user_id)
VALUES ('charlz petzold', '8800555', 1),('andrey streltsov', '8800555', 1),('charlz petzold', '8800555', 2),('charlz petzold', '8800555', 3);

-- alter table users
--     add constraint "fk_user_contacts"
--         foreign key (phonebook) references contacts (user_id);