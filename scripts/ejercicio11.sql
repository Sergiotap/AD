create type tip_telefonos is varray (3) of varchar(15);
/
create type tip_direccion as object(
    calle varchar(50),
    poblacion varchar(50),
    codpos varchar(20),
    provincia varchar(40)
);
/
create type tip_cliente as object(
    idcliente number,
    nombre varchar(50),
    direc tip_direccion,
    nif varchar(9),
    telef tip_telefonos
);
/
create type tip_producto as object(
    idproducto number,
    descripcion varchar(80),
    pvp number,
    stockactual number
);
/
create type tip_linea_venta(
    numerolinea number,
    idproducto REF tip_producto,
    cantidad number
);
/
create type tip_lineas_venta as table of tip_linea_venta;
create type tip_venta as object(
    idventa number,
    idcliente REF tip_cliente,
    fechaventa date,
    lineas tip_lineas_venta,
    MEMBER FUNCTION total_venta return number
);
/
create or replace type body tip_linea_venta as
MEMBER FUNCTION total_venta return number is
n number;
begin
    select count(*) from tip_lineas_venta into n;
end;
/