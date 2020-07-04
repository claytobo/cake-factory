CREATE TABLE IF NOT EXISTS Pastry (
    id SERIAL PRIMARY KEY,
    name varchar(20),
    price numeric
);

INSERT INTO Pastry(name, price) VALUES ('Cherry Pie', 10.50);
INSERT INTO Pastry(name, price) VALUES ('Chocolate Pie', 10.50);
INSERT INTO Pastry(name, price) VALUES ('Lemon Pie', 10.50);
INSERT INTO Pastry(name, price) VALUES ('Pecan Pie', 10.50);
INSERT INTO Pastry(name, price) VALUES ('Blueberry Muffin', 10.50);
INSERT INTO Pastry(name, price) VALUES ('Chocolate Cake', 10.50);