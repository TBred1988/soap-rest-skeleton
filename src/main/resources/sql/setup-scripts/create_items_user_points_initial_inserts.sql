-- Sequence: seq_items_sequence

-- DROP SEQUENCE seq_items_sequence;

CREATE SEQUENCE seq_items_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;
ALTER TABLE seq_items_sequence
  OWNER TO postgres;

  
-- Sequence: seq_user_point_sequence

-- DROP SEQUENCE seq_user_point_sequence;

CREATE SEQUENCE seq_user_point_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_user_point_sequence
  OWNER TO postgres;


-- CREATE the tables  
-- Table: items

-- DROP TABLE items;

CREATE TABLE items
(
  id bigint NOT NULL,
  short_name character varying(200) NOT NULL,
  name character varying(1000) NOT NULL,
  price_hu double precision NOT NULL,
  CONSTRAINT "PK_ITEMS" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE items
  OWNER TO postgres;

  
-- Table: user_point

-- DROP TABLE user_point;

CREATE TABLE user_point
(
  id bigint NOT NULL,
  act_point bigint,
  user_id bigint,
  CONSTRAINT "PK_USER_POINT" PRIMARY KEY (id),
  CONSTRAINT "FK_USER_POINT_TO_USER" FOREIGN KEY (user_id)
      REFERENCES "user" (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_point
  OWNER TO postgres;


--INSERT section

INSERT INTO items(
            id, short_name, name, price_hu)
    VALUES (1, 'margherita pizza', 'margherita pizza', 1100);

INSERT INTO user_point(
            id, act_point, user_id)
    VALUES (1, 0, 14);
