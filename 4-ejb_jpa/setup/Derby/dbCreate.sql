 
DROP TABLE STUDENT;
DROP TABLE EMPLOYEE;
 
CREATE TABLE STUDENT
(
   STUDENTID     BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   FIRSTNAME    VARCHAR(20) NOT NULL,
   LASTNAME    VARCHAR(20) NOT NULL,
   DEPARTMENT  VARCHAR(20) NOT NULL,
   FEES        DECIMAL(10,2),
   CONSTRAINT  PK_STUDENT  PRIMARY KEY(STUDENTID)
);

 
 
CREATE TABLE EMPLOYEE
(
   EMPLOYEEID     BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   FIRSTNAME    VARCHAR(40) NOT NULL,
   LASTNAME    VARCHAR(20) NOT NULL,
   COMPANY     VARCHAR(20) NOT NULL,
   HOURLYRATE  DECIMAL(10,2),
   CONSTRAINT  PK_EMPLOYEE  PRIMARY KEY(EMPLOYEEID)
);

INSERT INTO STUDENT VALUES(DEFAULT,'Eric','Colbert','Chemistry', 150.00);
INSERT INTO STUDENT VALUES(DEFAULT,'Stephen','Cheadle','Physiscs', 150.00);
INSERT INTO STUDENT VALUES(DEFAULT,'Anne','Mouvier','Chemistry', 150.00);
INSERT INTO STUDENT VALUES(DEFAULT,'Amy','Hilbert','French', 135.50);
INSERT INTO STUDENT VALUES(DEFAULT,'Ester','Freeman','French', 135.50);
INSERT INTO STUDENT VALUES(DEFAULT,'Paul','Cruthers','Biology', 145.00);
INSERT INTO STUDENT VALUES(DEFAULT,'Brian','Duvall','Physics', 150.00);
INSERT INTO STUDENT VALUES(DEFAULT,'Charles','Simpson','English', 125.00);

INSERT INTO EMPLOYEE VALUES(DEFAULT,'Eric','Colbert','CBS', 45.00);
INSERT INTO EMPLOYEE VALUES(DEFAULT,'Jason','Stewart','Comedy Central', 55.00);
INSERT INTO EMPLOYEE VALUES(DEFAULT,'Martha','Stolwart','Cooking Channel', 145.00);
INSERT INTO EMPLOYEE VALUES(DEFAULT,'Grayson','Norton','Travel', 65.00);
INSERT INTO EMPLOYEE VALUES(DEFAULT,'Alysin','Cosmos','CNN', 75.00);

 