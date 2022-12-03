insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10001, 'Rodrigo', 'Get Full-Stack Certification', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10002, 'Rodrigo', 'Get Python Certification', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10003, 'Rodrigo', 'Master Back-End Programming', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (10004, 'Rodrigo', 'Get AWS Certified', CURRENT_DATE(), false);

USE todo_db;

insert into users (id, email, password, username)
VALUES (1,'rodrigo@rodrigo.com','password','rodrigo')