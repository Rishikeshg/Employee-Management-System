create table Employee(
   id INT NOT NULL AUTO_INCREMENT,
   email_id VARCHAR(100) NOT NULL,
   first_name VARCHAR(40) NOT NULL,
   last_name VARCHAR(40) NOT NULL,
   PRIMARY KEY ( id )
);

create table User(
   id INT NOT NULL AUTO_INCREMENT,
   email_id VARCHAR(100) NOT NULL,
   address VARCHAR(40) NOT NULL,
   mobile_number VARCHAR(40) NOT NULL,
   password VARCHAR(40) NOT NULL,
   user_name VARCHAR(40) NOT NULL,
   PRIMARY KEY ( id )
);