-- Reiniciar la base de datos para evitar errores
DROP DATABASE IF EXISTS sistema_ventas;
CREATE DATABASE sistema_ventas;
USE sistema_ventas;

-- Creacion de tablas
CREATE TABLE CATEGORIA (
    categoria_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE PROVEEDOR (
    proveedor_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100)
);

CREATE TABLE EMPLEADO (
    empleado_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    puesto VARCHAR(50)
);

CREATE TABLE CLIENTE (
    cliente_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(15)
);

CREATE TABLE PRODUCTO (
    producto_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(5,2) NOT NULL,
    stock INTEGER NOT NULL,
    categoria_id INTEGER,
    proveedor_id INTEGER,
    FOREIGN KEY (categoria_id) REFERENCES CATEGORIA(categoria_id),
    FOREIGN KEY (proveedor_id) REFERENCES PROVEEDOR(proveedor_id)
);

CREATE TABLE VENTA (
    venta_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    empleado_id INTEGER NOT NULL,
    cliente_id INTEGER NOT NULL,
    FOREIGN KEY (empleado_id) REFERENCES EMPLEADO(empleado_id),
    FOREIGN KEY (cliente_id) REFERENCES CLIENTE(cliente_id)
);

CREATE TABLE DETALLEVENTA (
    venta_id INTEGER,
    producto_id INTEGER,
    cantidad INTEGER NOT NULL,
    precio_venta DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (venta_id, producto_id),
    FOREIGN KEY (venta_id) REFERENCES VENTA(venta_id),
    FOREIGN KEY (producto_id) REFERENCES PRODUCTO(producto_id)
);

-- Insertar datos de prueba
INSERT INTO CATEGORIA (nombre) VALUES
('Electrónica'),
('Ropa'),
('Hogar');

INSERT INTO PROVEEDOR (nombre, contacto) VALUES
('Samsung', 'contacto@samsung.com'),
('Nike', 'ventas@nike.com');

INSERT INTO EMPLEADO (nombre, puesto) VALUES
('Juan Pérez', 'Vendedor'),
('Ana Gómez', 'Gerente');

INSERT INTO CLIENTE (nombre, email) VALUES
('Carlos López', 'carlos@mail.com'),
('Maria Ruiz', 'maria@mail.com');

INSERT INTO PRODUCTO (nombre, precio, stock, categoria_id, proveedor_id) VALUES
('Smart TV 50"', 499.99, 10, 1, 1),
('Audífonos Bluetooth', 29.99, 50, 1, 1),
('Tenis Running', 89.50, 20, 2, 2);

INSERT INTO VENTA (empleado_id, cliente_id) VALUES
(1, 1),
(2, 2);

INSERT INTO DETALLEVENTA (venta_id, producto_id, cantidad, precio_venta) VALUES
(1, 1, 1, 499.99),
(1, 2, 2, 29.99),
(2, 3, 1, 89.50);


-- 1. Reporte de Productos Disponibles
SELECT
    p.nombre as Producto,
    p.stock,
    pr.nombre as Proveedor,
    c.nombre as Categoria
FROM PRODUCTO p
JOIN PROVEEDOR pr ON p.proveedor_id = pr.proveedor_id
JOIN CATEGORIA c ON p.categoria_id = c.categoria_id
WHERE p.stock > 0;

-- 2. Reporte de Venta Total por Cliente
SELECT
    v.venta_id as Folio,
    e.nombre as Vendedor,
    c.nombre as Cliente,
    p.nombre as Producto,
    dv.cantidad,
    dv.precio_venta,
    (dv.cantidad * dv.precio_venta) as Subtotal
FROM VENTA v
JOIN EMPLEADO e ON v.empleado_id = e.empleado_id
JOIN CLIENTE c ON v.cliente_id = c.cliente_id
JOIN DETALLEVENTA dv ON v.venta_id = dv.venta_id
JOIN PRODUCTO p ON dv.producto_id = p.producto_id;

-- 3. Reporte de Venta por Cliente
SELECT
    c.nombre as Cliente,
    SUM(dv.cantidad * dv.precio_venta) as Total_Pagado
FROM CLIENTE c
JOIN VENTA v ON c.cliente_id = v.cliente_id
JOIN DETALLEVENTA dv ON v.venta_id = dv.venta_id
GROUP BY c.cliente_id, c.nombre;
