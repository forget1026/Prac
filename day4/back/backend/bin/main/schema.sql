DROP TABLE IF EXISTS electric;
 
CREATE TABLE electric (
  no INT AUTO_INCREMENT PRIMARY KEY,
  hour INT NOT NULL,
  consumption INT NOT NULL,
  unitprice INT NOT NULL,
  cost INT NOT NULL
);

INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (0, 41, 57, 2346);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (1, 40, 57, 2316);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (2, 44, 57, 2518);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (3, 40, 57, 2291);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (4, 41, 57, 2332);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (5, 40, 57, 2279);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (6, 39, 57, 2211);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (7, 40, 57, 2274);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (8, 49, 57, 2785);
INSERT INTO electric (hour, consumption, unitprice, cost) VALUES (9, 81, 65, 5280);
