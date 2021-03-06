INSERT INTO users
VALUES (1, 'test1', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true , 'CLIENT'),
       (2, 'test2', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', false , 'CLIENT'),
       (3, 'test3', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true, 'OPERATOR'),
       (4, 'test4', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true, 'MANAGER'),
       (5, 'test5', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true, 'THIRD_PARTY_SPECIALIST'),
       (6, 'test6', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true , 'ADMIN'),
       (7, 'test7', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true , 'MANAGER'),
       (8, 'test8', '$2a$11$4jSYmoqJ4PUvBLmFpQd.ouxhlxisrpi165/dwU6zHFszRvOcWgWGG', true , 'MANAGER');

INSERT INTO banks
VALUES (1, 'PRIOR BANK'),
       (2, 'ALFA BANK'),
       (3, 'BEL INVEST BANK');

INSERT INTO managers
VALUES (1, 1, 4),
       (2, 2, 7),
       (3, 3, 8);


INSERT INTO companies
VALUES (1, 1, 'OOO', 'ISSOFT', '1013125934', 'Partizansky avenue 1, Minsk, 220070, Belarus'),
       (2, 1, 'OOO', 'EPAM', '1401125934', 'Partizansky avenue 2, Minsk, 220070, Belarus'),
       (3, 1, 'OAO', 'ANDERSEN', '101125934', 'Partizansky avenue 3, Minsk, 220070, Belarus'),
       (4, 2, 'OOO', 'PLAYTIKA', '134344343', 'Partizansky avenue 4, Minsk, 220070, Belarus'),
       (5, 2, 'OAO', 'INNOWISE', '544322232', 'Partizansky avenue 5, Minsk, 220070, Belarus'),
       (6, 2, 'OOO', 'LUX SOFT', '43434322', 'Partizansky avenue 6, Minsk, 220070, Belarus'),
       (7, 3, 'OAO', 'IBA', '32323444', 'Partizansky avenue, Minsk 7, 220070, Belarus'),
       (8, 3, 'OOO', 'Itransition', '32345777', 'Partizansky avenue 8, Minsk, 220070, Belarus'),
       (9, 3, 'OOO', 'Exadel', '101125934', 'Partizansky avenue 9, Minsk, 220070, Belarus'),
       (10, 3, 'OOO', 'SoftTeco', '101425998', 'Partizansky avenue 10, Minsk, 220070, Belarus');

INSERT INTO clients
VALUES (1, 1, 'Dovgun', 'Victoria', 'Alexandrovna', 'AB2718892992', '100', '+375292889911', 'rondarchik@proton.com', 1),
       (2, 2, 'Dovgun', 'Elena', 'Alexandrovna', 'AB2718890143', '101', '+3752953368882', 'elennaaa@proton.com', 1);


INSERT INTO client_bank
VALUES (1, 1),
       (1, 2),
       (2, 1);

INSERT INTO salary_projects
VALUES (1, 1, 'Salary safety'),
       (2, 2, 'Salary safety'),
       (3, 3, 'Salary safety'),
       (4, 4, 'Salary safety'),
       (5, 5, 'Salary safety'),
       (6, 6, 'Salary safety'),
       (7, 7, 'Salary safety'),
       (8, 8, 'Salary safety'),
       (9, 9, 'Salary safety'),
       (10, 10, 'Salary safety');

INSERT INTO company_accounts
VALUES (1, 1, 1, 1531, 'USD'),
       (2, 1, 1, 11930, 'BYN');

INSERT INTO client_accounts
VALUES (1, 1, 1, 1531, 'USD', 0, 0),
       (2, 1, 1, 11930, 'BYN', 0, 0);
