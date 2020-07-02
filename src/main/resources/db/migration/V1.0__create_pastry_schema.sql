CREATE TABLE IF NOT EXISTS pastry_entity (
    id SERIAL PRIMARY KEY,
    name varchar(20),
    price numeric
);

INSERT INTO pastry_entity(name, price) VALUES ('Cherry Pie', 10.50);
INSERT INTO pastry_entity(name, price) VALUES ('Chocolate Pie', 10.50);
INSERT INTO pastry_entity(name, price) VALUES ('Lemon Pie', 10.50);
INSERT INTO pastry_entity(name, price) VALUES ('Pecan Pie', 10.50);
INSERT INTO pastry_entity(name, price) VALUES ('Blueberry Muffin', 10.50);
INSERT INTO pastry_entity(name, price) VALUES ('Chocolate Cake', 10.50);