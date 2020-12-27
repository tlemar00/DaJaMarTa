-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.16-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para inso1
CREATE DATABASE IF NOT EXISTS `insoFinal1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `insoFinal1`;

-- Volcando estructura para tabla inso1.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `IdCategoria` int NOT NULL,
  `NombreCategoria` varchar(75) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla inso1.categorias: ~0 rows (aproximadamente)
DELETE FROM `categorias`;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;

-- Volcando estructura para tabla inso1.propiedades
CREATE TABLE IF NOT EXISTS `propiedades` (
  `IdPropiedad` int NOT NULL,
  `Nombre` varchar(50) COLLATE armscii8_bin NOT NULL,
  `Precio` float NOT NULL,
  `Ubicacion` varchar(300) COLLATE armscii8_bin NOT NULL,
  `Tamanio` float DEFAULT NULL,
  `TipoPropiedad` varchar(100) COLLATE armscii8_bin DEFAULT NULL,
  PRIMARY KEY (`IdPropiedad`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla inso1.propiedades: ~0 rows (aproximadamente)
DELETE FROM `propiedades`;
/*!40000 ALTER TABLE `propiedades` DISABLE KEYS */;
/*!40000 ALTER TABLE `propiedades` ENABLE KEYS */;

-- Volcando estructura para tabla inso1.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `IdUsuario` varchar(100) COLLATE armscii8_bin NOT NULL,
  `Contrasenia` char(24) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla inso1.usuarios: ~0 rows (aproximadamente)
DELETE FROM `usuarios`;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

-- Volcando estructura para tabla inso1.empleadobbdd
CREATE TABLE IF NOT EXISTS `empleadobbdd` (
  `idEmpleado` int(11) NOT NULL,
  `Nombre` varchar(50) COLLATE armscii8_bin NOT NULL,
  `Apellido1` varchar(75) COLLATE armscii8_bin NOT NULL,
  `Apellido2` varchar(75) COLLATE armscii8_bin NOT NULL,
  `NIFNIE` char(10) COLLATE armscii8_bin NOT NULL,
  `Email` varchar(75) COLLATE armscii8_bin NOT NULL,
  `Puesto` varchar(75) COLLATE armscii8_bin NOT NULL,
  `IdUsuario` varchar(100) COLLATE armscii8_bin NOT NULL,
  `IdCategoria` int NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  FOREIGN KEY (IdUsuario) references usuarios(IdUsuario),
  FOREIGN KEY (IdCategoria) references categorias(IdCategoria)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Volcando datos para la tabla inso1.empleadobbdd: ~0 rows (aproximadamente)
DELETE FROM `empleadobbdd`;
/*!40000 ALTER TABLE `empleadobbdd` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleadobbdd` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
