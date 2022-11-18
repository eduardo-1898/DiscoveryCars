CREATE DATABASE DiscoveryCars;

use DiscoveryCars;

Create TABLE Modelo(
	id int not null primary key auto_increment,
    Modelo varchar(150)
);

CREATE TABLE Marca(
	id int not null primary key auto_increment,
    Marca varchar(150)
);

CREATE TABLE Roles(
	id int not null primary key auto_increment,
    Nombre_Role varchar(150),
    Fecha_Creacion date
);

CREATE TABLE Departamento(
	Id int not null primary key auto_increment,
    Nombre_Departamento varchar(150)
);

CREATE TABLE Cliente(
	Id int not null primary key auto_increment,
    Cedula varchar(25) not null,
    Nombre_Cliente varchar(30) not null,
    Apellido1 varchar(30) not null,
    Apellido2 varchar(30) not null,
    Correo varchar(150) not null,
    Telefono int,
    Direccion varchar(300)
);

CREATE TABLE Empleado(
	Id int not null primary key auto_increment,
    Cedula varchar(25) not null,
    Nombre_Empleado varchar(30) not null,
    Apellido1 varchar(30) not null,
    Nombre_Usuario varchar(30) not null,
    Password varchar(150) not null,
    Estado boolean,
    id_Role int not null,
    CONSTRAINT FK_Empleado_Rol
    FOREIGN KEY(id_Role)
    REFERENCES Roles(id)
);

CREATE TABLE Vehiculos(
	placa varchar(9) not null primary key,
    Id_Marca int not null,
    Id_Modelo int not null,
	Ano int not null,
    Color varchar(50),
    Precio_Compra int not null,
    Estado boolean,
    CONSTRAINT FK_Vehiculos_marca
    FOREIGN KEY(Id_Marca)
    REFERENCES Marca(id),
	CONSTRAINT FK_Vehiculos_modelo
    FOREIGN KEY(Id_Modelo)
    REFERENCES Modelo(id)
);

CREATE TABLE Mantenimiento(
	Id int not null primary key auto_increment,
    Placa varchar(9) not null,
    Id_Departamento int not null,
    Id_Empleado int not null,
    Descripcion_Mantenimiento varchar(300),
    Fecha_Ingreso date,
    CONSTRAINT FK_Mantenimiento_vehiculo
    FOREIGN KEY(Placa)
    REFERENCES Vehiculos(placa),
    CONSTRAINT FK_Mantenimiento_Departamento
    FOREIGN KEY(Id_Departamento)
    REFERENCES Departamento(Id),
	CONSTRAINT FK_Mantenimiento_Empleado
    FOREIGN KEY(Id_Empleado)
    REFERENCES Empleado(Id)
);

CREATE TABLE Encabezado(
	Id int not null primary key,
    Id_Empleado int not null,
    Id_Cliente int not null,
    Fecha_Venta date,
	CONSTRAINT FK_Encabezado_Empleado
    FOREIGN KEY(Id_Empleado)
    REFERENCES Empleado(Id),
    CONSTRAINT FK_Encabezado_Cliente
    FOREIGN KEY(Id_Cliente)
    REFERENCES Cliente(Id)
);


CREATE TABLE Venta(
	IdVenta int not null primary key,
    Id_Factura int not null,
    Placa varchar(9) not null,
    Precio_Venta int not null,
    CONSTRAINT FK_Venta_Encabezado
    FOREIGN KEY(Id_Factura)
    REFERENCES Encabezado(Id)
);


CREATE TABLE StockVehiculos(
	placa varchar(9) not null primary key,
    Ultima_Modificacion date not null,
    Estado_Vehiculo varchar(30) NOT NULL,
    id_Modelo int not null,
    id_Marca int not null,
    cliente_Asociado int,
    Fecha_Venta date,
	CONSTRAINT FK_Stock_marca
    FOREIGN KEY(id_Marca)
    REFERENCES Marca(id),
	CONSTRAINT FK_Stock_modelo
    FOREIGN KEY(id_Modelo)
    REFERENCES Modelo(id)
);

DELIMITER $$
CREATE TRIGGER tr_ActualizaVenta
AFTER INSERT ON Venta FOR EACH ROW
BEGIN
	UPDATE StockVehiculos 
	SET Ultima_modificacion = now(), 
		Estado_Vehiculo = 'VENDIDO', 
		cliente_Asociado = (select Id_Cliente FROM Encabezado WHERE Id_Factura = New.Id_Factura),
		Fecha_Venta = now() 
		WHERE Placa = New.Placa;
END;
$$

DELIMITER $$
CREATE TRIGGER tr_CreaCompra
AFTER INSERT ON Vehiculos FOR EACH ROW
BEGIN
	INSERT INTO StockVehiculos(placa, Ultima_Modificacion, Estado_Vehiculo, id_Modelo, id_Marca, Fecha_Venta, cliente_asociado)
    VALUES(New.Placa, now(), 'NUEVO', New.Id_Modelo, New.Id_Marca, now(), null);
END;
$$

INSERT INTO Roles(Nombre_role, Fecha_Creacion)
VALUES('Mantenimientos',now());
INSERT INTO Roles(Nombre_role, Fecha_Creacion)
VALUES('Ventas',now());
INSERT INTO Roles(Nombre_role, Fecha_Creacion)
VALUES('Administrador',now());


INSERT INTO departamento(Nombre_Departamento)
VALUES ('Taller Mecánico');
INSERT INTO departamento(Nombre_Departamento)
VALUES ('Enderezado y pintura');
INSERT INTO departamento(Nombre_Departamento)
VALUES ('Aceites y frenos');
INSERT INTO departamento(Nombre_Departamento)
VALUES ('Lavado y entrega');


INSERT INTO Marca(Marca)
VALUES('HONDA');
INSERT INTO Marca(Marca)
VALUES('Hyundai');
INSERT INTO Marca(Marca)
VALUES('Nissan');
INSERT INTO Marca(Marca)
VALUES('Renault');
INSERT INTO Marca(Marca)
VALUES('Suzuki');
INSERT INTO Marca(Marca)
VALUES('Toyota');

INSERT INTO Modelo(Modelo)VALUES('Accord');
INSERT INTO Modelo(Modelo)VALUES('Beat');
INSERT INTO Modelo(Modelo)VALUES('City');
INSERT INTO Modelo(Modelo)VALUES('Civic');
INSERT INTO Modelo(Modelo)VALUES('CR-V');
INSERT INTO Modelo(Modelo)VALUES('Element');
INSERT INTO Modelo(Modelo)VALUES('Fit');
INSERT INTO Modelo(Modelo)VALUES('Orthia');
INSERT INTO Modelo(Modelo)VALUES('HR-V');
INSERT INTO Modelo(Modelo)VALUES('Insight');
INSERT INTO Modelo(Modelo)VALUES('CR-Z');
INSERT INTO Modelo(Modelo)VALUES('HSV-010');
INSERT INTO Modelo(Modelo)VALUES('Integra');
INSERT INTO Modelo(Modelo)VALUES('Legend');
INSERT INTO Modelo(Modelo)VALUES('Logo');
INSERT INTO Modelo(Modelo)VALUES('Odyssey');
INSERT INTO Modelo(Modelo)VALUES('Pilot');
INSERT INTO Modelo(Modelo)VALUES('Ridgeline');
INSERT INTO Modelo(Modelo)VALUES('WRV');
INSERT INTO Modelo(Modelo)VALUES('Tucson');
INSERT INTO Modelo(Modelo)VALUES('Accent');
INSERT INTO Modelo(Modelo)VALUES('Avante');
INSERT INTO Modelo(Modelo)VALUES('Atos');
INSERT INTO Modelo(Modelo)VALUES('Aslan');
INSERT INTO Modelo(Modelo)VALUES('Elantra');
INSERT INTO Modelo(Modelo)VALUES('I10');
INSERT INTO Modelo(Modelo)VALUES('I20');
INSERT INTO Modelo(Modelo)VALUES('I30');
INSERT INTO Modelo(Modelo)VALUES('I40');
INSERT INTO Modelo(Modelo)VALUES('IONIQ');
INSERT INTO Modelo(Modelo)VALUES('Santa Fe');
INSERT INTO Modelo(Modelo)VALUES('Veloster');

