ALTER TABLE contact DROP CONSTRAINT contactcustomer_id
DROP TABLE customer_type
DROP TABLE customer
DROP TABLE contact
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'