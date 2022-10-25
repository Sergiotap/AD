drop table lineasventas cascade constraints;
drop table ventas cascade constraints;
drop table cliente cascade constraints;
drop table productos cascade constraints;
create table cliente(
    idcliente number primary key;
    nombre varchar2(50),
    direccion varchar2(50),
    poblacion varchar2(50),
    cdpostal number,
    provincia varchar2(50),
    nif varchar2(50),
    tel1 number,
    tel2 number,
    tel3 number);
create table productos(
    idproducto number primary key,
    descripcion varchar2(50),
    pvp number,
    stockactual number);
create table ventas(
    idventas number primary key,
    idcliente number,
    fechaventa date,
    CONSTRAINT FK_VENTAS_IDCLIENTE FOREIGN KEY (idcliente) REFERENCES cliente(idcliente));
create table lineasventas(
    numerolinea number,
    idventas number,
    idproducto number,
    cantidad number,
    CONSTRAINT PK_LINEASVENTAS PRIMARY KEY (numerolinea, idventas),
    CONSTRAINT FK_LINEASVENTAS_IDEVENTAS FOREIGN KEY (idventas) REFERENCES ventas(idventas),
    CONSTRAINT FK_LINEASVENTAS_ID_IDPRODUCTO FOREIGN KEY (idproducto) REFERENCES productos(idproducto));