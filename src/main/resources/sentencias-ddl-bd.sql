--database
-- create database banco_xyz;

-- Pais
CREATE TABLE pais (
	id serial NOT NULL,
	nombre varchar NOT null,
	CONSTRAINT pais_pkey PRIMARY KEY (id)
);

-- Ciudad
CREATE TABLE ciudad (
	id serial NOT NULL,
	nombre varchar NOT NULL,
	pais int NOT NULL,
	CONSTRAINT ciudad_pkey PRIMARY KEY (id)
);


ALTER TABLE ciudad ADD CONSTRAINT pais_fkey FOREIGN KEY (pais) REFERENCES pais(id);

-- clientes
CREATE TABLE clientes (
	id serial NOT NULL,
	nombre varchar NOT NULL,
	tipo_identificacion varchar NOT NULL,
	numero_identificacion varchar NOT NULL,
	estado boolean NOT NULL,
	telefono varchar NULL,
	ciudad int NOT NULL,
	direccion varchar NULL,
	fecha_nacimiento date NULL,
	fecha_creacion timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT clientes_pkey PRIMARY KEY (id),
	CONSTRAINT uk_clientes UNIQUE (tipo_identificacion, numero_identificacion)
);

ALTER TABLE clientes ADD CONSTRAINT ciudad_fkey FOREIGN KEY (ciudad) REFERENCES ciudad(id);

-- cuentas
CREATE TABLE cuentas (
	id serial NOT NULL,
	id_cliente int4 NOT NULL,
	tipo_cuenta varchar NOT NULL,
	numero_cuenta varchar NOT NULL,
	saldo decimal NOT NULL,
	estado boolean NOT NULL,
	fecha_creacion timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT cuentas_pkey PRIMARY KEY (id),
	CONSTRAINT uk_cuentas UNIQUE (tipo_cuenta, numero_cuenta)
);

ALTER TABLE cuentas ADD CONSTRAINT cuentas_fkey FOREIGN KEY (id_cliente) REFERENCES clientes(id);


-- OperaciÃ³n
CREATE TABLE operacion (
	id serial NOT NULL,
	nombre varchar NOT null,
	CONSTRAINT operacion_pkey PRIMARY KEY (id)
);

-- movimientos
CREATE TABLE movimientos (
	id serial NOT NULL,
	id_cuenta int NOT NULL,
	monto bigint NOT NULL,
	estado boolean NOT NULL,
	operacion int NOT NULL,
	fecha_transaccion timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transacciones_pkey PRIMARY KEY (id)
);

ALTER TABLE movimientos ADD CONSTRAINT movimientos_fkey FOREIGN KEY (id_cuenta) REFERENCES cuentas(id);
ALTER TABLE movimientos ADD CONSTRAINT operacion_fkey FOREIGN KEY (operacion) REFERENCES operacion(id);

-- plan de pruebas
-- pais
INSERT INTO pais (nombre) VALUES('colombia');

-- ciudad
INSERT INTO ciudad (nombre, pais) VALUES('pueblorrico', 1);

-- cliente
INSERT INTO clientes
(nombre, tipo_identificacion, numero_identificacion, estado, telefono, ciudad, direccion, fecha_nacimiento)
VALUES('Jaime Osorio', 'cedula', '1039420426', true, '3195533013', 1, 'vereda patual', CURRENT_TIMESTAMP);

-- cuenta
INSERT INTO cuentas
(id_cliente, tipo_cuenta, numero_cuenta, saldo, estado, fecha_creacion)
VALUES(1, 'ahorros', '1234567890', 10000000, true, CURRENT_TIMESTAMP);

-- operaciones
INSERT INTO operacion (nombre) VALUES('retiro');
INSERT INTO operacion (nombre) VALUES('consignacion');



