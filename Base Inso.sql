-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.22 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para insofinal1
CREATE DATABASE IF NOT EXISTS `insofinal1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `insofinal1`;

-- Volcando estructura para tabla insofinal1.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `IdCategoria` int NOT NULL,
  `NombreCategoria` varchar(75) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla insofinal1.categorias: ~1 rows (aproximadamente)
DELETE FROM `categorias`;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` (`IdCategoria`, `NombreCategoria`) VALUES
	(0, 'Admin');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;

-- Volcando estructura para tabla insofinal1.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `IdCliente` int NOT NULL,
  `Nombre` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `Apellido1` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `Apellido2` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `NIFNIE` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `Telefono` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`IdCliente`, `Nombre`, `Apellido1`, `Apellido2`, `NIFNIE`, `Telefono`) VALUES
	(0, 'Sergio', 'Martinez', 'Alvarez', '75124855L', '666555777'),
	(1, 'Sergio', 'Martinez', 'Alvarez', '75124855L', '666555777'),
	(2, 'Alberto', 'Martinez', 'Alvarez', '75127855L', '666888000');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla insofinal1.empleadobbdd
CREATE TABLE IF NOT EXISTS `empleadobbdd` (
  `idEmpleado` int NOT NULL,
  `Nombre` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `Apellido1` varchar(75) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `Apellido2` varchar(75) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `NIFNIE` char(10) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `Email` varchar(75) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `IdUsuario` varchar(100) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `IdCategoria` int NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `IdUsuario` (`IdUsuario`),
  KEY `IdCategoria` (`IdCategoria`),
  CONSTRAINT `empleadobbdd_ibfk_1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuarios` (`IdUsuario`),
  CONSTRAINT `empleadobbdd_ibfk_2` FOREIGN KEY (`IdCategoria`) REFERENCES `categorias` (`IdCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;


/*!40000 ALTER TABLE `empleadobbdd` DISABLE KEYS */;
INSERT INTO `empleadobbdd` (`idEmpleado`, `Nombre`, `Apellido1`, `Apellido2`, `NIFNIE`, `Email`, `IdUsuario`, `IdCategoria`) VALUES
	(0, 'asf', 'asdfb', 'dsbn', 'sadfb', 'gdsf', 'admin', 0);
/*!40000 ALTER TABLE `empleadobbdd` ENABLE KEYS */;

-- Volcando estructura para tabla insofinal1.propiedades
CREATE TABLE IF NOT EXISTS `propiedades` (
  `IdPropiedad` int NOT NULL,
  `Nombre` varchar(50) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `Precio` float NOT NULL,
  `Direccion` varchar(300) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `Ciudad` varchar(150) COLLATE armscii8_bin NOT NULL,
  `Provincia` varchar(45) COLLATE armscii8_bin NOT NULL,
  `Numero` varchar(45) COLLATE armscii8_bin NOT NULL,
  `Puerta` varchar(45) COLLATE armscii8_bin NOT NULL,
  `Piso` int NOT NULL,
  `Escalera` varchar(45) COLLATE armscii8_bin NOT NULL,
  `Vendido` int NOT NULL DEFAULT '0',
  `Reservado` int NOT NULL DEFAULT '0',
  `Imagen` varchar(1500) COLLATE armscii8_bin DEFAULT NULL,
  `Descripcion` varchar(3000) COLLATE armscii8_bin DEFAULT NULL,
  `Tamanio` float DEFAULT NULL,
  `TipoPropiedad` varchar(100) CHARACTER SET armscii8 COLLATE armscii8_bin DEFAULT NULL,
  `IdTrabajador` int NOT NULL,
  `IdCliente` int NOT NULL,
  PRIMARY KEY (`IdPropiedad`),
  KEY `empleadobbdd_ibfk_3_idx` (`IdTrabajador`),
  KEY `empleadobbdd_ibfk_4_idx` (`IdCliente`),
  CONSTRAINT `empleadobbdd_ibfk_3` FOREIGN KEY (`IdTrabajador`) REFERENCES `empleadobbdd` (`idEmpleado`),
  CONSTRAINT `empleadobbdd_ibfk_4` FOREIGN KEY (`IdCliente`) REFERENCES `clientes` (`IdCliente`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

/*!40000 ALTER TABLE `propiedades` DISABLE KEYS */;
/*!40000 ALTER TABLE `propiedades` ENABLE KEYS */;

-- Volcando estructura para tabla insofinal1.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `IdUsuario` varchar(100) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  `Contrasenia` char(24) CHARACTER SET armscii8 COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`IdUsuario`, `Contrasenia`) VALUES
	('admin', 'administrador1234567890*');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
