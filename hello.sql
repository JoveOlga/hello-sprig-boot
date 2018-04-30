
CREATE USER hello_user WITH PASSWORD 'hellopass';

CREATE DATABASE hello
WITH
OWNER = hello_user
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

\c hello;

CREATE TABLE public.contacts
(
    id bigserial NOT NULL,
    name character varying(25) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);

ALTER TABLE public.contacts
    OWNER to hello_user;

INSERT INTO public.contacts (name) VALUES ('Steve');
INSERT INTO public.contacts (name) VALUES ('Mike');
INSERT INTO public.contacts (name) VALUES ('Isobella');
INSERT INTO public.contacts (name) VALUES ('Alex');
INSERT INTO public.contacts (name) VALUES ('Madison');
INSERT INTO public.contacts (name) VALUES ('Sofia');
INSERT INTO public.contacts (name) VALUES ('Taylor');
INSERT INTO public.contacts (name) VALUES ('Mason');
INSERT INTO public.contacts (name) VALUES ('Emily');
INSERT INTO public.contacts (name) VALUES ('James');
INSERT INTO public.contacts (name) VALUES ('Katherine');
INSERT INTO public.contacts (name) VALUES ('Matthew');
INSERT INTO public.contacts (name) VALUES ('Hannah');
INSERT INTO public.contacts (name) VALUES ('Nicholas');
INSERT INTO public.contacts (name) VALUES ('Kaitlyn');
INSERT INTO public.contacts (name) VALUES ('Christopher');
INSERT INTO public.contacts (name) VALUES ('Kaitlyn');
INSERT INTO public.contacts (name) VALUES ('Sarah');
INSERT INTO public.contacts (name) VALUES ('Joseph');
INSERT INTO public.contacts (name) VALUES ('Brianna');
INSERT INTO public.contacts (name) VALUES ('Joshua');
INSERT INTO public.contacts (name) VALUES ('Kaylee');
INSERT INTO public.contacts (name) VALUES ('Andrew');
INSERT INTO public.contacts (name) VALUES ('Hailey');
INSERT INTO public.contacts (name) VALUES ('Daniel');
INSERT INTO public.contacts (name) VALUES ('Alexis');
INSERT INTO public.contacts (name) VALUES ('Christian');
INSERT INTO public.contacts (name) VALUES ('Lauren');
INSERT INTO public.contacts (name) VALUES ('Ryan');
INSERT INTO public.contacts (name) VALUES ('Ashley');
INSERT INTO public.contacts (name) VALUES ('Anthony');
INSERT INTO public.contacts (name) VALUES ('Jessica');
INSERT INTO public.contacts (name) VALUES ('Jonathan');
INSERT INTO public.contacts (name) VALUES ('Anna');
INSERT INTO public.contacts (name) VALUES ('David');
INSERT INTO public.contacts (name) VALUES ('Samantha');
INSERT INTO public.contacts (name) VALUES ('Dylan');
INSERT INTO public.contacts (name) VALUES ('Alissa');
INSERT INTO public.contacts (name) VALUES ('Jacob');
INSERT INTO public.contacts (name) VALUES ('Madeline');