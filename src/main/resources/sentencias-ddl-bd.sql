create database banco_xyz;

-- public.clientes definition

-- Drop table

-- DROP TABLE public.clientes;

CREATE TABLE public.clientes (
	id serial NOT NULL,
	nombre varchar NOT NULL,
	tipo_identificacion varchar NOT NULL,
	numero_identificacion varchar NOT NULL,
	estado bool NOT NULL,
	telefono varchar NULL,
	pais varchar NULL,
	ciudad varchar NULL,
	direccion varchar NULL,
	fecha_nacimiento date NULL,
	fecha_creacion timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT clientes_pkey PRIMARY KEY (id),
	CONSTRAINT uk_clientes UNIQUE (tipo_identificacion, numero_identificacion)
);

-- public.cuentas definition

-- Drop table

-- DROP TABLE public.cuentas;

CREATE TABLE public.cuentas (
	id serial NOT NULL,
	id_cliente int4 NOT NULL,
	tipo_cuenta varchar NOT NULL,
	numero_cuenta varchar NOT NULL,
	saldo numeric NOT NULL,
	estado bool NOT NULL,
	fecha_creacion timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT cuentas_pkey PRIMARY KEY (id),
	CONSTRAINT uk_cuentas UNIQUE (tipo_cuenta, numero_cuenta)
);


-- public.cuentas foreign keys

ALTER TABLE public.cuentas ADD CONSTRAINT cuentas_fkey FOREIGN KEY (id_cliente) REFERENCES clientes(id);

-- public.movimientos definition

-- Drop table

-- DROP TABLE public.movimientos;

CREATE TABLE public.movimientos (
	id serial NOT NULL,
	id_cuenta int4 NOT NULL,
	monto bool NOT NULL,
	estado varchar NOT NULL,
	operacion varchar NOT NULL,
	fecha_transaccion timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transacciones_pkey PRIMARY KEY (id)
);


-- public.movimientos foreign keys

ALTER TABLE public.movimientos ADD CONSTRAINT movimientos_fkey FOREIGN KEY (id_cuenta) REFERENCES cuentas(id);