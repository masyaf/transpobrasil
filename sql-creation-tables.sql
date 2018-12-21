CREATE SEQUENCE posting_code_seq
 INCREMENT 1
 START 1;
 
CREATE SEQUENCE item_code_seq
 INCREMENT 1
 START 1;
CREATE TABLE posting

(
  code bigint NOT NULL DEFAULT nextval('posting_code_seq'),
  amount numeric(8,2),
  final_date date,
  initial_date date,
  note character varying(1000),
  CONSTRAINT pk_posting PRIMARY KEY (code)
);


CREATE TABLE item
(
  code bigint NOT NULL DEFAULT nextval('item_code_seq'),
  description character varying(255),
  value numeric(8,2),
  CONSTRAINT pk_item PRIMARY KEY (code)
);



CREATE TABLE postingitem
(
  code_posting bigint NOT NULL,
  code_item bigint NOT NULL,
  CONSTRAINT pk_posting  FOREIGN KEY (code_posting)
      REFERENCES posting (code) MATCH SIMPLE
      ON UPDATE NO ACTION
       ON DELETE NO ACTION,
  CONSTRAINT pk_item  FOREIGN KEY (code_item)
      REFERENCES item (code) MATCH SIMPLE
      ON UPDATE NO ACTION 
      ON DELETE NO ACTION
);