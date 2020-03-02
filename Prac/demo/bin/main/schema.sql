DROP TABLE IF EXISTS testtbl;
 
CREATE TABLE testtbl (
  no INT AUTO_INCREMENT  PRIMARY KEY,
  age INT NOT NULL,
  username VARCHAR(250) NOT NULL,
  gender VARCHAR(250) NOT NULL
);

INSERT INTO testtbl (age, username, gender) VALUES (25, 'kim','male');
INSERT INTO testtbl (age, username, gender) VALUES (17, 'hong','female');