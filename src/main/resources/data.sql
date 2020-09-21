insert into education_type (id, name) values (1, 'uni');
insert into education_type (id, name) values (2, 'hoze');


-- insert into personal_information (id, first_name, last_name, national_code, main_phone, gender, birth_date, marital, photo)
-- values (1, 'ali', 'izadi', '23345', null, 0, null, 0 ,null );
--
-- insert into personal_information (id, first_name, last_name, national_code, main_phone, gender, birth_date, marital, photo)
-- values (2, 'amir', 'rahimi', '334', null, 0, null, 0 ,null );

insert into education_information (id, type_id, name) values (1, 1, 'BA');
insert into education_information (id, type_id, name) values (2, 1, 'MS');
insert into education_information (id, type_id, name) values (3, 1, 'PHD');
insert into education_information (id, type_id, name) values (4, 2, 'MADANI1');
insert into education_information (id, type_id, name) values (5, 2, 'KHAREG');

insert into contact (id, type, content) values (1, 0, 'A');
insert into contact (id, type, content) values (2, 0, 'B');
insert into contact (id, type, content) values (3, 0, 'C');
insert into contact (id, type, content) values (4, 1, 'D');
insert into contact (id, type, content) values (5, 2, 'E');


insert into personal_information (id, first_name, last_name, national_code, main_phone, address, gender, birth_date, marital, photo)
values (1, 'NAME1', 'FAMILY1', '1234', null, null, 0, null, 0, null);


insert into personal_information_contact (personal_information_id, contact_id) values (1, 1);
insert into personal_information_contact (personal_information_id, contact_id) values (1, 2);
insert into personal_information_contact (personal_information_id, contact_id) values (1, 3);





