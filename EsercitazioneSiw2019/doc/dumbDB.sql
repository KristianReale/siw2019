PGDMP     
                	    v           Segreteria2019    10.0    10.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            	           1262    20786    Segreteria2019    DATABASE     �   CREATE DATABASE "Segreteria2019" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';
     DROP DATABASE "Segreteria2019";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    20797    corso    TABLE     T   CREATE TABLE corso (
    codice bigint NOT NULL,
    nome character varying(255)
);
    DROP TABLE public.corso;
       public         postgres    false    3            �            1259    20815    iscritto    TABLE     p   CREATE TABLE iscritto (
    id bigint NOT NULL,
    matricola_studente character(8),
    corso_codice bigint
);
    DROP TABLE public.iscritto;
       public         postgres    false    3            �            1259    20789    scuola    TABLE     �   CREATE TABLE scuola (
    id bigint NOT NULL,
    codice_meccanografico character varying(255),
    nome character varying(255)
);
    DROP TABLE public.scuola;
       public         postgres    false    3            �            1259    20787    sequenza_id    SEQUENCE     m   CREATE SEQUENCE sequenza_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.sequenza_id;
       public       postgres    false    3            �            1259    20802    studente    TABLE     �   CREATE TABLE studente (
    matricola character(8) NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    data_nascita date,
    scuola_id bigint,
    password character varying(255)
);
    DROP TABLE public.studente;
       public         postgres    false    3                      0    20797    corso 
   TABLE DATA               &   COPY corso (codice, nome) FROM stdin;
    public       postgres    false    198                    0    20815    iscritto 
   TABLE DATA               A   COPY iscritto (id, matricola_studente, corso_codice) FROM stdin;
    public       postgres    false    200   S                 0    20789    scuola 
   TABLE DATA               :   COPY scuola (id, codice_meccanografico, nome) FROM stdin;
    public       postgres    false    197   �                 0    20802    studente 
   TABLE DATA               X   COPY studente (matricola, nome, cognome, data_nascita, scuola_id, password) FROM stdin;
    public       postgres    false    199   �                  0    0    sequenza_id    SEQUENCE SET     3   SELECT pg_catalog.setval('sequenza_id', 10, true);
            public       postgres    false    196            
           2606    20801    corso corso_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY corso
    ADD CONSTRAINT corso_pkey PRIMARY KEY (codice);
 :   ALTER TABLE ONLY public.corso DROP CONSTRAINT corso_pkey;
       public         postgres    false    198            �
           2606    20819    iscritto iscritto_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY iscritto
    ADD CONSTRAINT iscritto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.iscritto DROP CONSTRAINT iscritto_pkey;
       public         postgres    false    200            }
           2606    20796    scuola scuola_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY scuola
    ADD CONSTRAINT scuola_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.scuola DROP CONSTRAINT scuola_pkey;
       public         postgres    false    197            �
           2606    20809    studente studente_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY studente
    ADD CONSTRAINT studente_pkey PRIMARY KEY (matricola);
 @   ALTER TABLE ONLY public.studente DROP CONSTRAINT studente_pkey;
       public         postgres    false    199            �
           2606    20825 #   iscritto iscritto_corso_codice_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY iscritto
    ADD CONSTRAINT iscritto_corso_codice_fkey FOREIGN KEY (corso_codice) REFERENCES corso(codice);
 M   ALTER TABLE ONLY public.iscritto DROP CONSTRAINT iscritto_corso_codice_fkey;
       public       postgres    false    2687    198    200            �
           2606    20820 )   iscritto iscritto_matricola_studente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY iscritto
    ADD CONSTRAINT iscritto_matricola_studente_fkey FOREIGN KEY (matricola_studente) REFERENCES studente(matricola);
 S   ALTER TABLE ONLY public.iscritto DROP CONSTRAINT iscritto_matricola_studente_fkey;
       public       postgres    false    199    2689    200            �
           2606    20810     studente studente_scuola_id_fkey    FK CONSTRAINT     t   ALTER TABLE ONLY studente
    ADD CONSTRAINT studente_scuola_id_fkey FOREIGN KEY (scuola_id) REFERENCES scuola(id);
 J   ALTER TABLE ONLY public.studente DROP CONSTRAINT studente_scuola_id_fkey;
       public       postgres    false    199    197    2685               7   x�3�OMRp��-(-��K����KOM�K-�LTHI�Q�O+)O,J����� r��         +   x�3�4� cN.3��1�q�K�2.C��W� �         K   x�3�r�v51vq3��,.�,)-�W�M�I�K)��2+037F�wϬ���2J:����/J������� ���         c   x�30 CΠ���LN�Ģ�|NCKKS]c]#CNc�?.�#NǼ�DΰԢ�L�3]]C#5�@5%�y@C�2�3�
-tt�v���qqq ��X     