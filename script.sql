DROP DATABASE IF EXISTS housing;
CREATE DATABASE HOUSING;

\c HOUSING;
--drop the existing sequence and table if they exist
DROP SEQUENCE IF EXISTS HOUSING_SEQ;
DROP TABLE IF EXISTS HOUSE;

--create the sequence
CREATE SEQUENCE HOUSING_SEQ START WITH 3647 INCREMENT BY 1 MAXVALUE 2147483647 NO CYCLE;

--create the table
CREATE TABLE HOUSE(
    H_ID SERIAL PRIMARY KEY,
    H_NAME VARCHAR(255),
    H_ADDRESS VARCHAR(255),
    H_CITY VARCHAR(255)
);

-- Insert values into the HOUSE table
INSERT INTO HOUSE (H_ID, H_NAME, H_ADDRESS, H_CITY) VALUES
(nextval('HOUSING_SEQ'), 'Green Villa', '123 Maple St', 'Springfield'),
(nextval('HOUSING_SEQ'), 'Sunset Apartments', '456 Oak St', 'Shelbyville'),
(nextval('HOUSING_SEQ'), 'Lakeview Manor', '789 Pine St', 'Capital City'),
(nextval('HOUSING_SEQ'), 'Riverfront Condo', '101 Elm St', 'Ogdenville'),
(nextval('HOUSING_SEQ'), 'Mountain Retreat', '202 Cedar St', 'North Haverbrook');

-- Verify the data by selecting from the table
SELECT * FROM HOUSE;