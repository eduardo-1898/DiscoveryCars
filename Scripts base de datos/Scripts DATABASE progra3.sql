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
    NombreDepartamento varchar(150)
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
    cliente_Asociado int not null,
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
	SET Ultima_modificacion = SYSDATE(), 
		Estado_Vehiculo = 'VENDIDO', 
		cliente_Asociado = (select Id_Cliente FROM Encabezado WHERE Id_Factura = New.Id_Factura),
		FechaV_enta = SYSDATE() 
		WHERE Placa = New.Placa;
END;
$$

DELIMITER $$
CREATE TRIGGER tr_CreaCompra
AFTER INSERT ON Vehiculos FOR EACH ROW
BEGIN
	INSERT INTO StockVehiculos(placa, UltimaModificacion, EstadoVehiculo, id_Modelo, id_Marca, FechaVenta)
    VALUES(New.Placa, SYSDATE(), 'NUEVO', New.Id_Modelo, New.Id_Marca, SYSDATE());
END;
$$