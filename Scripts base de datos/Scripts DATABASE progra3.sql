CREATE DATABASE DiscoveryCars;

use DiscoveryCars;

Create TABLE Modelo(
	idModelo int not null primary key auto_increment,
    Modelo varchar(150)
);

CREATE TABLE Marca(
	idMarca int not null primary key auto_increment,
    Marca varchar(150)
);

CREATE TABLE Roles(
	idRole int not null primary key auto_increment,
    NombreRole varchar(150),
    FechaCreacion date
);

CREATE TABLE Departamento(
	IdDepartamento int not null primary key auto_increment,
    NombreDepartamento varchar(150)
);

CREATE TABLE Cliente(
	IdCliente int not null primary key auto_increment,
    Cedula varchar(25) not null,
    NombreCliente varchar(30) not null,
    Apellido1 varchar(30) not null,
    Apellido2 varchar(30) not null,
    Correo varchar(150) not null,
    Telefono int,
    Direccion varchar(300)
);

CREATE TABLE Empleado(
	IdEmpleado int not null primary key auto_increment,
    Cedula varchar(25) not null,
    NombreEmpleado varchar(30) not null,
    Apellido1 varchar(30) not null,
    NombreUsuario varchar(30) not null,
    Password varchar(150) not null,
    Estado boolean,
    idRole int not null,
    CONSTRAINT FK_Empleado_Rol
    FOREIGN KEY(idRole)
    REFERENCES Roles(idRole)
);

CREATE TABLE Vehiculos(
	placa varchar(9) not null primary key,
    IdMarca int not null,
    IdModelo int not null,
	Ano int not null,
    Color varchar(50),
    PrecioCompra int not null,
    Estado boolean,
    CONSTRAINT FK_Vehiculos_marca
    FOREIGN KEY(IdMarca)
    REFERENCES Marca(idMarca),
	CONSTRAINT FK_Vehiculos_modelo
    FOREIGN KEY(IdModelo)
    REFERENCES Modelo(idModelo)
);

CREATE TABLE Mantenimiento(
	IdMantenimiento int not null primary key auto_increment,
    Placa varchar(9) not null,
    IdDepartamento int not null,
    IdEmpleado int not null,
    DescripcionMantenimiento varchar(300),
    FechaIngreso date,
    CONSTRAINT FK_Mantenimiento_vehiculo
    FOREIGN KEY(Placa)
    REFERENCES Vehiculos(placa),
    CONSTRAINT FK_Mantenimiento_Departamento
    FOREIGN KEY(IdDepartamento)
    REFERENCES Departamento(IdDepartamento),
	CONSTRAINT FK_Mantenimiento_Empleado
    FOREIGN KEY(IdEmpleado)
    REFERENCES Empleado(IdEmpleado)
);

CREATE TABLE Encabezado(
	IdFactura int not null primary key,
    IdEmpleado int not null,
    IdCliente int not null,
    FechaVenta date,
	CONSTRAINT FK_Encabezado_Empleado
    FOREIGN KEY(IdEmpleado)
    REFERENCES Empleado(IdEmpleado),
    CONSTRAINT FK_Encabezado_Cliente
    FOREIGN KEY(IdCliente)
    REFERENCES Cliente(IdCliente)
);


CREATE TABLE Venta(
	IdVenta int not null primary key,
    IdFactura int not null,
    Placa varchar(9) not null,
    PrecioVenta int not null,
    CONSTRAINT FK_Venta_Encabezado
    FOREIGN KEY(IdFactura)
    REFERENCES Encabezado(IdFactura)
);


CREATE TABLE StockVehiculos(
	placa varchar(9) not null primary key,
    UltimaModificacion date not null,
    EstadoVehiculo varchar(30) NOT NULL,
    idModelo int not null,
    idMarca int not null,
    clienteAsociado int not null,
    FechaVenta date,
	CONSTRAINT FK_Stock_marca
    FOREIGN KEY(idMarca)
    REFERENCES Marca(idMarca),
	CONSTRAINT FK_Stock_modelo
    FOREIGN KEY(idModelo)
    REFERENCES Modelo(idModelo)
);


DELIMITER $$
CREATE TRIGGER tr_ActualizaVenta
AFTER INSERT ON Venta FOR EACH ROW
BEGIN
	UPDATE StockVehiculos 
	SET UltimaModificacion = SYSDATE(), 
		EstadoVehiculo = 'VENDIDO', 
		clienteAsociado = (select IdCliente FROM Encabezado WHERE IdFactura = New.IdFactura),
		FechaVenta = SYSDATE() 
		WHERE Placa = New.Placa;
END;
$$

DELIMITER $$
CREATE TRIGGER tr_CreaCompra
AFTER INSERT ON Vehiculos FOR EACH ROW
BEGIN
	INSERT INTO StockVehiculos(placa, UltimaModificacion, EstadoVehiculo, idModelo, idMarca, FechaVenta)
    VALUES(New.Placa, SYSDATE(), 'NUEVO', New.IdModelo, New.IdMarca, SYSDATE());
END;
$$