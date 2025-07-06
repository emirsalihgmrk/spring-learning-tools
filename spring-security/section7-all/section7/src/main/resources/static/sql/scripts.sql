create table users
(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(500) not null,
    enabled  boolean not null
);

create table authorities
(
    username  varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username, authority);

INSERT IGNORE INTO `users` VALUES ('user', '{noop}gumruk@12345', '1');
INSERT IGNORE INTO `authorities` VALUES ('user', 'read');

INSERT IGNORE INTO `users` VALUES ('admin', '{bcrypt}$2a$12$lyHRf5zv64spscwvlJUJs.e3xpS9cS.AGMDhm27EozkJz7nLryOUm', '1');
INSERT IGNORE INTO `authorities` VALUES ('admin', 'admin');

CREATE TABLE customer(
                         id INTEGER NOT NULL AUTO_INCREMENT,
                         email VARCHAR(45) NOT NULL,
                         pwd VARCHAR(200) NOT NULL,
                         role VARCHAR(45) NOT NULL,
                         PRIMARY KEY (id)
);

INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('happy@example.com', '{noop}gumruk@12345', 'read');
INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('admin@example.com', '{bcrypt}$2a$12$lyHRf5zv64spscwvlJUJs.e3xpS9cS.AGMDhm27EozkJz7nLryOUm', 'admin');