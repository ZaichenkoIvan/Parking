INSERT INTO cars VALUES (1,'BMW');
INSERT INTO cars VALUES (2,'Mustang');

INSERT INTO clients VALUES (1,'Vanya');
INSERT INTO clients VALUES (2,'Stasya');

INSERT INTO car_clients VALUES (1, 1, 1);
INSERT INTO car_clients VALUES (2, 2, 2);

INSERT INTO parkings VALUES (1, 'silpo');
INSERT INTO parkings VALUES (2, 'atb');

INSERT INTO parking_spaces VALUES (1, 1);
INSERT INTO parking_spaces VALUES (2, 2);
INSERT INTO parking_spaces VALUES (3, 1);
INSERT INTO parking_spaces VALUES (4, 2);

insert into coupons
values
(1, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
 TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 1, 1);

insert into coupons
values
(2, TO_DATE('2015/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
 TO_DATE('2015/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 1, 2);

insert into coupons
values
(3, TO_DATE('2018/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
 TO_DATE('2018/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 2, 3);

insert into coupons
values
(4, TO_DATE('2020/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),
 TO_DATE('2020/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 2, 4);
