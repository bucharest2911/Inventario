PGDMP     5    )            
    y         
   Inventario    11.14    11.14                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393 
   Inventario    DATABASE     ?   CREATE DATABASE "Inventario" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE "Inventario";
             postgres    false            ?            1259    16396    cargos    TABLE     a   CREATE TABLE public.cargos (
    id integer NOT NULL,
    nombre_cargo character varying(255)
);
    DROP TABLE public.cargos;
       public         postgres    false            ?            1259    16394    cargos_id_seq    SEQUENCE     ?   ALTER TABLE public.cargos ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cargos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    197            ?            1259    16415 	   mercancia    TABLE     ?   CREATE TABLE public.mercancia (
    id integer NOT NULL,
    cantidad integer,
    fecha_creacion timestamp without time zone,
    fecha_ingreso timestamp without time zone,
    nombre_mercancia character varying(255),
    usuario_creado integer
);
    DROP TABLE public.mercancia;
       public         postgres    false            ?            1259    16413    mercancia_id_seq    SEQUENCE     ?   ALTER TABLE public.mercancia ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.mercancia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    201            ?            1259    16430    mercancia_usuario    TABLE     ?   CREATE TABLE public.mercancia_usuario (
    mercancia_id integer NOT NULL,
    usuario_modifica integer NOT NULL,
    fecha_de_modificacion timestamp without time zone
);
 %   DROP TABLE public.mercancia_usuario;
       public         postgres    false            ?            1259    16403    usuarios    TABLE     ?   CREATE TABLE public.usuarios (
    id integer NOT NULL,
    edad integer,
    fecha_ingreso timestamp without time zone,
    nombre_usuario character varying(255),
    cargo_id integer
);
    DROP TABLE public.usuarios;
       public         postgres    false            ?            1259    16401    usuarios_id_seq    SEQUENCE     ?   ALTER TABLE public.usuarios ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    199                      0    16396    cargos 
   TABLE DATA               2   COPY public.cargos (id, nombre_cargo) FROM stdin;
    public       postgres    false    197   ?                 0    16415 	   mercancia 
   TABLE DATA               r   COPY public.mercancia (id, cantidad, fecha_creacion, fecha_ingreso, nombre_mercancia, usuario_creado) FROM stdin;
    public       postgres    false    201   D                 0    16430    mercancia_usuario 
   TABLE DATA               b   COPY public.mercancia_usuario (mercancia_id, usuario_modifica, fecha_de_modificacion) FROM stdin;
    public       postgres    false    202   ?                 0    16403    usuarios 
   TABLE DATA               U   COPY public.usuarios (id, edad, fecha_ingreso, nombre_usuario, cargo_id) FROM stdin;
    public       postgres    false    199   ?                  0    0    cargos_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.cargos_id_seq', 1, true);
            public       postgres    false    196                        0    0    mercancia_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.mercancia_id_seq', 5, true);
            public       postgres    false    200            !           0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 2, true);
            public       postgres    false    198            ?
           2606    16400    cargos cargos_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cargos
    ADD CONSTRAINT cargos_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cargos DROP CONSTRAINT cargos_pkey;
       public         postgres    false    197            ?
           2606    16419    mercancia mercancia_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.mercancia
    ADD CONSTRAINT mercancia_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.mercancia DROP CONSTRAINT mercancia_pkey;
       public         postgres    false    201            ?
           2606    16434 (   mercancia_usuario mercancia_usuario_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.mercancia_usuario
    ADD CONSTRAINT mercancia_usuario_pkey PRIMARY KEY (mercancia_id, usuario_modifica);
 R   ALTER TABLE ONLY public.mercancia_usuario DROP CONSTRAINT mercancia_usuario_pkey;
       public         postgres    false    202    202            ?
           2606    16407    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public         postgres    false    199            ?
           2606    16445 -   mercancia_usuario fk1kjm3o5m65qbhqixwyfhslyx8    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mercancia_usuario
    ADD CONSTRAINT fk1kjm3o5m65qbhqixwyfhslyx8 FOREIGN KEY (usuario_modifica) REFERENCES public.usuarios(id);
 W   ALTER TABLE ONLY public.mercancia_usuario DROP CONSTRAINT fk1kjm3o5m65qbhqixwyfhslyx8;
       public       postgres    false    202    2704    199            ?
           2606    16408 $   usuarios fk65oyat1njp8ljm3nof536upvj    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fk65oyat1njp8ljm3nof536upvj FOREIGN KEY (cargo_id) REFERENCES public.cargos(id);
 N   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT fk65oyat1njp8ljm3nof536upvj;
       public       postgres    false    2702    197    199            ?
           2606    16440 -   mercancia_usuario fkgk5hs6bn4qtijvqp4w9qhvm0n    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mercancia_usuario
    ADD CONSTRAINT fkgk5hs6bn4qtijvqp4w9qhvm0n FOREIGN KEY (mercancia_id) REFERENCES public.mercancia(id);
 W   ALTER TABLE ONLY public.mercancia_usuario DROP CONSTRAINT fkgk5hs6bn4qtijvqp4w9qhvm0n;
       public       postgres    false    2706    201    202            ?
           2606    16425 %   mercancia fkn73d6q1f0ptgr9okilin40kuk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mercancia
    ADD CONSTRAINT fkn73d6q1f0ptgr9okilin40kuk FOREIGN KEY (usuario_creado) REFERENCES public.usuarios(id);
 O   ALTER TABLE ONLY public.mercancia DROP CONSTRAINT fkn73d6q1f0ptgr9okilin40kuk;
       public       postgres    false    201    199    2704               :   x?3?t,N-?/RHIU(K?+I,?2?,?/?/*I?2?LL????,.)JL?/?????? ?8?         ?   x?}?+?0Fa}??n ???G??up????C?c???? ??w@BD)s7)?f+n=?D?:@???$?JǓ?n1^?5h?O?????s!??<6??n9?;}????<?{?v ?ԓ0k????J.)??z?1            x?????? ? ?         :   x?3?4??4202?5"s+0?HM)??4?2?46@(?@(*MJ??4?????? ???     