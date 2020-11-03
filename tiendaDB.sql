--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: actfunccategoria(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.actfunccategoria() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_categoria
(nombreAnt,descripcionAnt,nombreNew,descripcionNew,
usuario,modificado,id_categoria)
values
(OLD.nombre,OLD.descripcion,
NEW.nombre,NEW.descripcion,
CURRENT_USER,NOW(),NEW.id_categoria);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.actfunccategoria() OWNER TO valle;

--
-- Name: actfunccliente(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.actfunccliente() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_clientes
(nomAnt,aPatAnt,aMatAnt,direccionAnt,feNacAnt,telefonoAnt,
emailAnt,usuarioAnt,passAnt,nomNew,aPatNew,aMatNew,direccionNew,
feNacNew,telefonoNew,emailNew,usuarioNew,passNew,usuario,
modificado,id_cliente)
values
(OLD.nombre,OLD.aPaterno,OLD.aMaterno,OLD.direccion,OLD.fecha_nacimiento,
OLD.telefono,OLD.email,OLD.usuario,OLD.pass,NEW.nombre,NEW.aPaterno,NEW.aMaterno,NEW.direccion,NEW.fecha_nacimiento,
NEW.telefono,NEW.email,NEW.usuario,NEW.pass,
CURRENT_USER,NOW(),NEW.id_cliente);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.actfunccliente() OWNER TO valle;

--
-- Name: actfuncfactura(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.actfuncfactura() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_factura
(id_clienteAnt,totalAnt,fechaAnt,id_clienteNew,
totalNew,fechaNew,usuario,modificado,num_factura)
values
(OLD.id_cliente,OLD.total,OLD.fecha,
NEW.id_cliente,NEW.total,NEW.fecha,
CURRENT_USER,NOW(),NEW.num_factura);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.actfuncfactura() OWNER TO valle;

--
-- Name: actfuncproducto(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.actfuncproducto() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_producto
(nombreAnt,descripcionAnt,precioAnt,stockAnt,imageAnt,descuentoAnt,
id_categoriaAnt,nombreNew,descripcionNew,precioNew,stockNew,imageNew,
descuentoNew,id_categoriaNew,usuario,modificado,id_producto)
values
(OLD.nombre,OLD.descripcion,OLD.precio,OLD.stock,
OLD.image,OLD.descuento,OLD.id_categoria,
NEW.nombre,NEW.descripcion,NEW.precio,NEW.stock,
NEW.image,NEW.descuento,NEW.id_categoria ,
CURRENT_USER,NOW(),NEW.id_producto);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.actfuncproducto() OWNER TO valle;

--
-- Name: borrarfunccategoria(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.borrarfunccategoria() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_categoria
(nombreAnt,descripcionAnt,usuario,modificado,id_categoria)
values
(OLD.nombre,OLD.descripcion,
CURRENT_USER,NOW(),OLD.id_categoria);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.borrarfunccategoria() OWNER TO valle;

--
-- Name: borrarfunccliente(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.borrarfunccliente() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_clientes
(nomAnt,aPatAnt,aMatAnt,direccionAnt,feNacAnt,telefonoAnt,
emailAnt,usuarioAnt,passAnt,usuario,modificado,id_cliente)
values
(OLD.nombre,OLD.aPaterno,OLD.aMaterno,OLD.direccion,
OLD.fecha_nacimiento,OLD.telefono,OLD.email,OLD.usuario,
OLD.pass,CURRENT_USER,NOW(),OLD.id_cliente);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.borrarfunccliente() OWNER TO valle;

--
-- Name: borrarfuncfactura(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.borrarfuncfactura() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_factura
(id_clienteAnt,totalAnt,fechaAnt,usuario,modificado,num_factura)
values
(OLD.id_cliente,OLD.total,OLD.fecha,
CURRENT_USER,NOW(),OLD.num_factura);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.borrarfuncfactura() OWNER TO valle;

--
-- Name: borrarfuncproducto(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.borrarfuncproducto() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_producto
(nombreAnt,descripcionAnt,precioAnt,stockAnt,imageAnt,descuentoAnt,
id_categoriaAnt,usuario,modificado,id_producto)
values
(OLD.nombre,OLD.descripcion,OLD.precio,OLD.stock,
OLD.image,OLD.descuento,OLD.id_categoria,
CURRENT_USER,NOW(),OLD.id_producto);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.borrarfuncproducto() OWNER TO valle;

--
-- Name: crear_fecha(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.crear_fecha() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
NEW.fecha := now();
RETURN NEW;
END;

$$;


ALTER FUNCTION public.crear_fecha() OWNER TO valle;

--
-- Name: insertfunccategoria(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.insertfunccategoria() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_categoria
(nombreNew, descripcionNew,usuario,modificado,id_categoria)
values
(NEW.nombre,NEW.descripcion,
CURRENT_USER,NOW(),NEW.id_categoria);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.insertfunccategoria() OWNER TO valle;

--
-- Name: insertfunccliente(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.insertfunccliente() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_clientes
(nomNew,aPatNew,aMatNew,direccionNew,
feNacNew,telefonoNew,emailNew,usuarioNew,passNew,usuario,
modificado,id_cliente)
values
(NEW.nombre,NEW.aPaterno,NEW.aMaterno,NEW.direccion,NEW.fecha_nacimiento,
NEW.telefono,NEW.email,NEW.usuario,NEW.pass,
CURRENT_USER,NOW(),NEW.id_cliente);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.insertfunccliente() OWNER TO valle;

--
-- Name: insertfuncfactura(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.insertfuncfactura() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_factura
(id_clienteNew, totalNew,fechaNew,usuario,modificado,num_factura)
values
(NEW.id_cliente,NEW.total,NEW.fecha,
CURRENT_USER,NOW(),NEW.num_factura);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.insertfuncfactura() OWNER TO valle;

--
-- Name: insertfuncproducto(); Type: FUNCTION; Schema: public; Owner: valle
--

CREATE FUNCTION public.insertfuncproducto() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN
insert into auditoria_producto
(nombreNew,descripcionNew,precioNew,stockNew,imageNew,
descuentoNew,id_categoriaNew,usuario,modificado,id_producto)
values
(NEW.nombre,NEW.descripcion,NEW.precio,NEW.stock,
NEW.image,NEW.descuento,NEW.id_categoria ,
CURRENT_USER,NOW(),NEW.id_producto);
RETURN NEW;
END;
$$;


ALTER FUNCTION public.insertfuncproducto() OWNER TO valle;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: auditoria_categoria; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.auditoria_categoria (
    id integer NOT NULL,
    nombreant character varying(45),
    descripcionant character varying(100),
    nombrenew character varying(45),
    descripcionnew character varying(100),
    usuario character varying(45),
    modificado timestamp without time zone,
    id_categoria integer
);


ALTER TABLE public.auditoria_categoria OWNER TO valle;

--
-- Name: auditoria_categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.auditoria_categoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auditoria_categoria_id_seq OWNER TO valle;

--
-- Name: auditoria_categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.auditoria_categoria_id_seq OWNED BY public.auditoria_categoria.id;


--
-- Name: auditoria_clientes; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.auditoria_clientes (
    id integer NOT NULL,
    nomant character varying(45),
    apatant character varying(45),
    amatant character varying(45),
    direccionant character varying(500),
    fenacant date,
    telefonoant bigint,
    emailant character varying(100),
    usuarioant character varying(45),
    passant character varying(45),
    nomnew character varying(45),
    apatnew character varying(45),
    amatnew character varying(45),
    direccionnew character varying(500),
    fenacnew date,
    telefononew bigint,
    emailnew character varying(100),
    usuarionew character varying(45),
    passnew character varying(45),
    usuario character varying(45),
    modificado timestamp without time zone,
    id_cliente integer
);


ALTER TABLE public.auditoria_clientes OWNER TO valle;

--
-- Name: auditoria_clientes_id_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.auditoria_clientes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auditoria_clientes_id_seq OWNER TO valle;

--
-- Name: auditoria_clientes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.auditoria_clientes_id_seq OWNED BY public.auditoria_clientes.id;


--
-- Name: auditoria_factura; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.auditoria_factura (
    id integer NOT NULL,
    id_clienteant integer,
    totalant double precision,
    fechaant timestamp without time zone,
    id_clientenew integer,
    totalnew double precision,
    fechanew timestamp without time zone,
    usuario character varying(45),
    modificado timestamp without time zone,
    num_factura integer
);


ALTER TABLE public.auditoria_factura OWNER TO valle;

--
-- Name: auditoria_factura_id_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.auditoria_factura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auditoria_factura_id_seq OWNER TO valle;

--
-- Name: auditoria_factura_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.auditoria_factura_id_seq OWNED BY public.auditoria_factura.id;


--
-- Name: auditoria_producto; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.auditoria_producto (
    id integer NOT NULL,
    nombreant character varying(45),
    descripcionant character varying(450),
    precioant double precision,
    stockant integer,
    imageant character varying(100),
    descuentoant integer,
    id_categoriaant integer,
    nombrenew character varying(45),
    descripcionnew character varying(450),
    precionew double precision,
    stocknew integer,
    imagenew character varying(100),
    descuentonew integer,
    id_categorianew integer,
    usuario character varying(45),
    modificado timestamp without time zone,
    id_producto integer
);


ALTER TABLE public.auditoria_producto OWNER TO valle;

--
-- Name: auditoria_producto_id_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.auditoria_producto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auditoria_producto_id_seq OWNER TO valle;

--
-- Name: auditoria_producto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.auditoria_producto_id_seq OWNED BY public.auditoria_producto.id;


--
-- Name: categoria; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.categoria (
    id_categoria integer NOT NULL,
    nombre character varying(45),
    descripcion character varying(100)
);


ALTER TABLE public.categoria OWNER TO valle;

--
-- Name: categoria_id_categoria_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.categoria_id_categoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_id_categoria_seq OWNER TO valle;

--
-- Name: categoria_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.categoria_id_categoria_seq OWNED BY public.categoria.id_categoria;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    nombre character varying(45),
    apaterno character varying(45),
    amaterno character varying(45),
    direccion character varying(500),
    fecha_nacimiento date,
    telefono bigint,
    email character varying(100),
    usuario character varying(45),
    pass character varying(45)
);


ALTER TABLE public.cliente OWNER TO valle;

--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_cliente_seq OWNER TO valle;

--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;


--
-- Name: detalle; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.detalle (
    num_detalle integer NOT NULL,
    id_factura integer,
    nombreprod character varying(45),
    cantidad integer,
    precio double precision
);


ALTER TABLE public.detalle OWNER TO valle;

--
-- Name: detalle_num_detalle_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.detalle_num_detalle_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_num_detalle_seq OWNER TO valle;

--
-- Name: detalle_num_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.detalle_num_detalle_seq OWNED BY public.detalle.num_detalle;


--
-- Name: envio; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.envio (
    id_envio integer NOT NULL,
    num_factura integer,
    direccion character varying(500),
    cp integer,
    estado character varying(45)
);


ALTER TABLE public.envio OWNER TO valle;

--
-- Name: envio_id_envio_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.envio_id_envio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.envio_id_envio_seq OWNER TO valle;

--
-- Name: envio_id_envio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.envio_id_envio_seq OWNED BY public.envio.id_envio;


--
-- Name: factura; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.factura (
    num_factura integer NOT NULL,
    id_cliente integer,
    total double precision,
    fecha timestamp without time zone
);


ALTER TABLE public.factura OWNER TO valle;

--
-- Name: factura_num_factura_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.factura_num_factura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.factura_num_factura_seq OWNER TO valle;

--
-- Name: factura_num_factura_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.factura_num_factura_seq OWNED BY public.factura.num_factura;


--
-- Name: producto; Type: TABLE; Schema: public; Owner: valle
--

CREATE TABLE public.producto (
    id_producto integer NOT NULL,
    nombre character varying(45),
    descripcion character varying(450),
    precio double precision,
    stock integer,
    image character varying(100),
    descuento integer,
    id_categoria integer
);


ALTER TABLE public.producto OWNER TO valle;

--
-- Name: producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: valle
--

CREATE SEQUENCE public.producto_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_producto_seq OWNER TO valle;

--
-- Name: producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: valle
--

ALTER SEQUENCE public.producto_id_producto_seq OWNED BY public.producto.id_producto;


--
-- Name: auditoria_categoria id; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_categoria ALTER COLUMN id SET DEFAULT nextval('public.auditoria_categoria_id_seq'::regclass);


--
-- Name: auditoria_clientes id; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_clientes ALTER COLUMN id SET DEFAULT nextval('public.auditoria_clientes_id_seq'::regclass);


--
-- Name: auditoria_factura id; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_factura ALTER COLUMN id SET DEFAULT nextval('public.auditoria_factura_id_seq'::regclass);


--
-- Name: auditoria_producto id; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_producto ALTER COLUMN id SET DEFAULT nextval('public.auditoria_producto_id_seq'::regclass);


--
-- Name: categoria id_categoria; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id_categoria SET DEFAULT nextval('public.categoria_id_categoria_seq'::regclass);


--
-- Name: cliente id_cliente; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);


--
-- Name: detalle num_detalle; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.detalle ALTER COLUMN num_detalle SET DEFAULT nextval('public.detalle_num_detalle_seq'::regclass);


--
-- Name: envio id_envio; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.envio ALTER COLUMN id_envio SET DEFAULT nextval('public.envio_id_envio_seq'::regclass);


--
-- Name: factura num_factura; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.factura ALTER COLUMN num_factura SET DEFAULT nextval('public.factura_num_factura_seq'::regclass);


--
-- Name: producto id_producto; Type: DEFAULT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.producto ALTER COLUMN id_producto SET DEFAULT nextval('public.producto_id_producto_seq'::regclass);


--
-- Data for Name: auditoria_categoria; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.auditoria_categoria (id, nombreant, descripcionant, nombrenew, descripcionnew, usuario, modificado, id_categoria) FROM stdin;
1	\N	\N	Telefono	dfghj	valle	2019-05-28 00:27:10.224164	1
2	Telefono	dfghj	Telefono	hola	valle	2019-05-28 00:28:48.530537	1
3	\N	\N	Computadoras	sdfghjk	valle	2019-05-28 00:28:56.986422	2
4	Computadoras	sdfghjk	\N	\N	valle	2019-05-28 00:29:10.661555	2
5	\N	\N	Computadoras	dfghj	valle	2019-05-28 00:37:58.079611	3
\.


--
-- Data for Name: auditoria_clientes; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.auditoria_clientes (id, nomant, apatant, amatant, direccionant, fenacant, telefonoant, emailant, usuarioant, passant, nomnew, apatnew, amatnew, direccionnew, fenacnew, telefononew, emailnew, usuarionew, passnew, usuario, modificado, id_cliente) FROM stdin;
1	\N	\N	\N	\N	\N	\N	\N	\N	\N	Marco Antonio	Velazquez	Lopez	Norte 22 Mz 962 Lt 1 Norte 21 y Norte 22 Camion caja blanca enfrente 56615 Valle de Chalco Solidaridad Mexico	1995-08-12	5545656785	markuzvelazquez@gmail.com	marco	holaMundo123	valle	2019-05-27 22:56:34.428102	1
2	Marco Antonio	Velazquez	Lopez	Norte 22 Mz 962 Lt 1 Norte 21 y Norte 22 Camion caja blanca enfrente 56615 Valle de Chalco Solidaridad Mexico	1995-08-12	5545656785	markuzvelazquez@gmail.com	marco	holaMundo123	Marco Antonio	Velázquez	López	Norte 22 Mz 962 Lt 1 Norte 21 y Norte 22 Camion caja blanca enfrente 56615 Valle de Chalco Solidaridad Mexico	1995-08-12	5545656785	markuzvelazquez@gmail.com	marco	holaMundo123	valle	2019-05-27 23:50:00.950751	1
3	\N	\N	\N	\N	\N	\N	\N	\N	\N	asd	qwe	zxc	null null null null null null null null null	2019-05-01	34578	a@a.a	aldo	asdASD123	valle	2019-05-27 23:55:41.268314	2
4	asd	qwe	zxc	null null null null null null null null null	2019-05-01	34578	a@a.a	aldo	asdASD123	\N	\N	\N	\N	\N	\N	\N	\N	\N	valle	2019-05-28 00:25:14.339258	2
5	Marco Antonio	Velázquez	López	Norte 22 Mz 962 Lt 1 Norte 21 y Norte 22 Camion caja blanca enfrente 56615 Valle de Chalco Solidaridad Mexico	1995-08-12	5545656785	markuzvelazquez@gmail.com	marco	holaMundo123	Marco Antonio	Velázquez	López	Norte 22 Mz 962 Lt 1 Norte 21 y Norte 22 Camion caja blanca enfrente 56615 Valle de Chalco Solidaridad Mexico	1995-08-13	5545656785	markuzvelazquez@gmail.com	marco	holaMundo123	valle	2019-05-28 00:25:40.891455	1
\.


--
-- Data for Name: auditoria_factura; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.auditoria_factura (id, id_clienteant, totalant, fechaant, id_clientenew, totalnew, fechanew, usuario, modificado, num_factura) FROM stdin;
1	\N	\N	\N	1	11000	2019-05-28 00:52:12.155764	valle	2019-05-28 00:52:12.155764	1
2	\N	\N	\N	1	11000	2019-05-28 00:53:44.165543	valle	2019-05-28 00:53:44.165543	2
\.


--
-- Data for Name: auditoria_producto; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.auditoria_producto (id, nombreant, descripcionant, precioant, stockant, imageant, descuentoant, id_categoriaant, nombrenew, descripcionnew, precionew, stocknew, imagenew, descuentonew, id_categorianew, usuario, modificado, id_producto) FROM stdin;
1	\N	\N	\N	\N	\N	\N	\N	Lenovo	Computadora	11000	2	\N	0	3	valle	2019-05-28 00:48:36.132891	2
2	Lenovo	Computadora	11000	2	\N	0	3	Lenovo	Computadora	11000	2	descarga.jpg	0	3	valle	2019-05-28 00:50:39.560381	2
3	\N	\N	\N	\N	\N	\N	\N	Moto G4	Telefono	4000	100	\N	10	3	valle	2019-05-28 00:51:19.932525	3
4	Moto G4	Telefono	4000	100	\N	10	3	\N	\N	\N	\N	\N	\N	\N	valle	2019-05-28 00:52:03.660477	3
5	Lenovo	Computadora	11000	2	descarga.jpg	0	3	Lenovo	Computadora	11000	1	descarga.jpg	0	3	valle	2019-05-28 00:53:44.071912	2
6	Lenovo	Computadora	11000	1	descarga.jpg	0	3	Lenovo	Computadora	11000	0	descarga.jpg	0	3	valle	2019-05-28 00:57:00.98077	2
\.


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.categoria (id_categoria, nombre, descripcion) FROM stdin;
1	Telefono	hola
3	Computadoras	dfghj
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.cliente (id_cliente, nombre, apaterno, amaterno, direccion, fecha_nacimiento, telefono, email, usuario, pass) FROM stdin;
1	Marco Antonio	Velázquez	López	Norte 22 Mz 962 Lt 1 Norte 21 y Norte 22 Camion caja blanca enfrente 56615 Valle de Chalco Solidaridad Mexico	1995-08-13	5545656785	markuzvelazquez@gmail.com	marco	holaMundo123
\.


--
-- Data for Name: detalle; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.detalle (num_detalle, id_factura, nombreprod, cantidad, precio) FROM stdin;
1	2	Lenovo	1	11000
\.


--
-- Data for Name: envio; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.envio (id_envio, num_factura, direccion, cp, estado) FROM stdin;
\.


--
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.factura (num_factura, id_cliente, total, fecha) FROM stdin;
1	1	11000	2019-05-28 00:52:12.155764
2	1	11000	2019-05-28 00:53:44.165543
\.


--
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: valle
--

COPY public.producto (id_producto, nombre, descripcion, precio, stock, image, descuento, id_categoria) FROM stdin;
2	Lenovo	Computadora	11000	0	descarga.jpg	0	3
\.


--
-- Name: auditoria_categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.auditoria_categoria_id_seq', 5, true);


--
-- Name: auditoria_clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.auditoria_clientes_id_seq', 5, true);


--
-- Name: auditoria_factura_id_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.auditoria_factura_id_seq', 2, true);


--
-- Name: auditoria_producto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.auditoria_producto_id_seq', 6, true);


--
-- Name: categoria_id_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.categoria_id_categoria_seq', 3, true);


--
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 2, true);


--
-- Name: detalle_num_detalle_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.detalle_num_detalle_seq', 1, true);


--
-- Name: envio_id_envio_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.envio_id_envio_seq', 1, false);


--
-- Name: factura_num_factura_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.factura_num_factura_seq', 2, true);


--
-- Name: producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: valle
--

SELECT pg_catalog.setval('public.producto_id_producto_seq', 3, true);


--
-- Name: auditoria_categoria auditoria_categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_categoria
    ADD CONSTRAINT auditoria_categoria_pkey PRIMARY KEY (id);


--
-- Name: auditoria_clientes auditoria_clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_clientes
    ADD CONSTRAINT auditoria_clientes_pkey PRIMARY KEY (id);


--
-- Name: auditoria_factura auditoria_factura_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_factura
    ADD CONSTRAINT auditoria_factura_pkey PRIMARY KEY (id);


--
-- Name: auditoria_producto auditoria_producto_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.auditoria_producto
    ADD CONSTRAINT auditoria_producto_pkey PRIMARY KEY (id);


--
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- Name: detalle detalle_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.detalle
    ADD CONSTRAINT detalle_pkey PRIMARY KEY (num_detalle);


--
-- Name: envio envio_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.envio
    ADD CONSTRAINT envio_pkey PRIMARY KEY (id_envio);


--
-- Name: factura factura_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (num_factura);


--
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id_producto);


--
-- Name: categoria actualiza_audi_categoria; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER actualiza_audi_categoria AFTER UPDATE ON public.categoria FOR EACH ROW EXECUTE PROCEDURE public.actfunccategoria();


--
-- Name: cliente actualiza_audi_clientes; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER actualiza_audi_clientes AFTER UPDATE ON public.cliente FOR EACH ROW EXECUTE PROCEDURE public.actfunccliente();


--
-- Name: factura actualiza_audi_factura; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER actualiza_audi_factura AFTER UPDATE ON public.factura FOR EACH ROW EXECUTE PROCEDURE public.actfuncfactura();


--
-- Name: producto actualiza_audi_producto; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER actualiza_audi_producto AFTER UPDATE ON public.producto FOR EACH ROW EXECUTE PROCEDURE public.actfuncproducto();


--
-- Name: factura crear_fecha; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER crear_fecha BEFORE INSERT ON public.factura FOR EACH ROW EXECUTE PROCEDURE public.crear_fecha();


--
-- Name: categoria elimina_audi_categoria; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER elimina_audi_categoria AFTER DELETE ON public.categoria FOR EACH ROW EXECUTE PROCEDURE public.borrarfunccategoria();


--
-- Name: cliente elimina_audi_cliente; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER elimina_audi_cliente AFTER DELETE ON public.cliente FOR EACH ROW EXECUTE PROCEDURE public.borrarfunccliente();


--
-- Name: factura elimina_audi_factura; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER elimina_audi_factura AFTER DELETE ON public.factura FOR EACH ROW EXECUTE PROCEDURE public.borrarfuncfactura();


--
-- Name: producto elimina_audi_producto; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER elimina_audi_producto AFTER DELETE ON public.producto FOR EACH ROW EXECUTE PROCEDURE public.borrarfuncproducto();


--
-- Name: categoria inserta_audi_categoria; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER inserta_audi_categoria AFTER INSERT ON public.categoria FOR EACH ROW EXECUTE PROCEDURE public.insertfunccategoria();


--
-- Name: cliente inserta_audi_cliente; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER inserta_audi_cliente AFTER INSERT ON public.cliente FOR EACH ROW EXECUTE PROCEDURE public.insertfunccliente();


--
-- Name: factura inserta_audi_factura; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER inserta_audi_factura AFTER INSERT ON public.factura FOR EACH ROW EXECUTE PROCEDURE public.insertfuncfactura();


--
-- Name: producto inserta_audi_producto; Type: TRIGGER; Schema: public; Owner: valle
--

CREATE TRIGGER inserta_audi_producto AFTER INSERT ON public.producto FOR EACH ROW EXECUTE PROCEDURE public.insertfuncproducto();


--
-- Name: detalle detalle_id_factura_fkey; Type: FK CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.detalle
    ADD CONSTRAINT detalle_id_factura_fkey FOREIGN KEY (id_factura) REFERENCES public.factura(num_factura);


--
-- Name: envio envio_num_factura_fkey; Type: FK CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.envio
    ADD CONSTRAINT envio_num_factura_fkey FOREIGN KEY (num_factura) REFERENCES public.factura(num_factura);


--
-- Name: factura factura_id_cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente);


--
-- Name: producto producto_id_categoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: valle
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

