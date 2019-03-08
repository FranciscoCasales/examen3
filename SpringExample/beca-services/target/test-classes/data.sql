INSERT INTO users (id, ds_name, ds_lastname, age)
VALUES
(1, 'Francisco', 'Casales', 24),
(2, 'Francisco 2', 'Casales', 24),
(3, 'Francisco 3', 'Casales', 24),
(4, 'Francisco 4', 'Casales', 24),
(5, 'Francisco 5', 'Casales', 24),
(6, 'Francisco 6', 'Casales', 24),
(7, 'Francisco 7', 'Casales', 24);
commit;
select count(*) from users;

alter sequence users_id_seq restart with 10;