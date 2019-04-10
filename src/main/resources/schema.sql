create table PERSON
(
   id integer auto_increment,
   Full_Name varchar(64) not null,
   Date_Of_Birth date not null,
   primary key(id)
);

 insert into PERSON (Full_Name,Date_Of_Birth) VALUES  ('John','2018-01-01');
 insert into PERSON (Full_Name,Date_Of_Birth) VALUES  ('Doe','2018-01-01');

CREATE table ORDERS
(
 id integer auto_increment,
 Title varchar(255),
 price number(64),
 person_id number(64),
 primary key(id)
);

 insert into ORDERS (Title, price, person_id) VALUES ('LALA',99,1);
 insert into ORDERS (Title, price, person_id) VALUES ('LALA-BLA!',100,1);
 insert into ORDERS (Title, price, person_id) VALUES ('LALA-LAND',101,2);

