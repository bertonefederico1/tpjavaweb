-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tpjava
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autos`
--

DROP TABLE IF EXISTS `autos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `autos` (
  `patente` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `marca` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modelo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `anio_fabricacion` int(10) unsigned DEFAULT NULL,
  `cantidad_km` int(10) unsigned DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `activo` varchar(42) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`patente`),
  KEY `fk_autos_clientes_idx` (`dni`),
  CONSTRAINT `fk_autos_clientes` FOREIGN KEY (`dni`) REFERENCES `clientes` (`dni`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autos`
--

LOCK TABLES `autos` WRITE;
/*!40000 ALTER TABLE `autos` DISABLE KEYS */;
INSERT INTO `autos` VALUES ('AB 905 PQ','Honda','Fit',0,0,40121097,'no'),('ABE 111','Prueba 2','Prueba',2019,0,11111111,'no'),('EVL 687','Honda','Fit',2009,10000,37817242,'si'),('GCJ 523','Ford','Mondeo',2019,34700,41091000,'si'),('HCK 456','Ford','Falcon',1980,190000,40121987,'si'),('IPC 102','Honda','City',2010,19000,37817242,'si'),('Papa 12','Papa movil','Vaticano',2020,0,40121097,'si'),('sdf','sdf','sdf',0,0,40121987,'no');
/*!40000 ALTER TABLE `autos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `dni` int(11) NOT NULL,
  `nombre_y_apellido` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (11111111,'Abel jeje','1111111','',''),(37817242,'Juan Perez','mitre 1234','','4212222'),(40121097,'Francisco 1','Entre Rios 2019','iojio@dddf',''),(40121987,'Elsa Lame','catamarca 1236','elsa21@gmail.com','155422123'),(41091000,'Esteban Quito','san juan 1287','esteban.quito@hotmail.com','425678');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanicos`
--

DROP TABLE IF EXISTS `mecanicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mecanicos` (
  `matricula` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_y_apellido` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contrasenia` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicos`
--

LOCK TABLES `mecanicos` WRITE;
/*!40000 ALTER TABLE `mecanicos` DISABLE KEYS */;
INSERT INTO `mecanicos` VALUES (1,'Hugo San','Saavedra 1050','huguito21@gmail.com','420927','1'),(6,'Alberto Marcovich','Sarmiento 1987','','4546','6');
/*!40000 ALTER TABLE `mecanicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `politicas_organizacion`
--

DROP TABLE IF EXISTS `politicas_organizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `politicas_organizacion` (
  `turnos_max_por_dia` int(11) DEFAULT NULL,
  `stock_minimo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `politicas_organizacion`
--

LOCK TABLES `politicas_organizacion` WRITE;
/*!40000 ALTER TABLE `politicas_organizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `politicas_organizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provee`
--

DROP TABLE IF EXISTS `provee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `provee` (
  `cod_repuesto` int(10) unsigned NOT NULL,
  `cuit` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `fk_provee_proveedores_idx` (`cuit`),
  KEY `fk_provee_repuestos_idx` (`cod_repuesto`),
  CONSTRAINT `fk_provee_proveedores` FOREIGN KEY (`cuit`) REFERENCES `proveedores` (`cuit`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_provee_repuestos` FOREIGN KEY (`cod_repuesto`) REFERENCES `repuestos` (`cod_repuesto`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provee`
--

LOCK TABLES `provee` WRITE;
/*!40000 ALTER TABLE `provee` DISABLE KEYS */;
/*!40000 ALTER TABLE `provee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedores` (
  `cuit` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `razon_social` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mail` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('20-37817454-1','COMON S.A','4219999','comonsa@gmail.com','Alberdi 1212'),('21-37897099-1','Pepito S.R.L','15657892','pepin65@yahoo.com','san martin 1200');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repa_repuestos`
--

DROP TABLE IF EXISTS `repa_repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `repa_repuestos` (
  `nro_reparacion` int(10) unsigned NOT NULL,
  `cod_repuesto` int(10) unsigned NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`nro_reparacion`,`cod_repuesto`),
  KEY `fk_repaRepuestos_repuestos_idx` (`cod_repuesto`),
  CONSTRAINT `fk_repaRepuestos_reparaciones` FOREIGN KEY (`nro_reparacion`) REFERENCES `reparaciones` (`nro_reparacion`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_repaRepuestos_repuestos` FOREIGN KEY (`cod_repuesto`) REFERENCES `repuestos` (`cod_repuesto`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repa_repuestos`
--

LOCK TABLES `repa_repuestos` WRITE;
/*!40000 ALTER TABLE `repa_repuestos` DISABLE KEYS */;
INSERT INTO `repa_repuestos` VALUES (19,24,1),(19,25,2),(19,27,1),(20,26,2),(20,27,1),(22,24,2),(24,26,2);
/*!40000 ALTER TABLE `repa_repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparaciones`
--

DROP TABLE IF EXISTS `reparaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reparaciones` (
  `nro_reparacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` date NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `estado` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion_final` varchar(5000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `detalle_inicial` varchar(5000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `observaciones` varchar(5000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patente` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `matricula` int(11) unsigned DEFAULT NULL,
  `activa` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mano_de_obra` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`nro_reparacion`),
  KEY `fk_reparaciones_mecanicos_idx` (`matricula`),
  KEY `fk_reparaciones_autos_idx` (`patente`),
  CONSTRAINT `fk_reparaciones_autos` FOREIGN KEY (`patente`) REFERENCES `autos` (`patente`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_reparaciones_mecanicos` FOREIGN KEY (`matricula`) REFERENCES `mecanicos` (`matricula`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparaciones`
--

LOCK TABLES `reparaciones` WRITE;
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` VALUES (19,'2019-11-28','2019-11-28','2019-11-28','2019-11-29','Entregada','Tests reparación final (Modificar reparación)','test reparaciones a realizar FINAL (ingreso)','test observaciones FINAL (ingreso)','EVL 687',1,'si',0.00),(20,'2019-11-28','2019-11-28','2019-11-28','2019-11-28','Entregada','Reparaciones realizadas (nueva reparación)','prueba 2 ingreso','prueba 2 ingreso','GCJ 523',1,'si',234.00),(21,'2019-11-28','2019-11-28','2019-11-28','2019-11-28','Entregada','prueba facturar','prueba facturar','prueba facturar','GCJ 523',1,'si',100.00),(22,'2019-11-29','2019-11-29','2019-11-29','2019-11-29','Entregada','Cambio de mecanico','Prueba Papa movil','prueba papa movil','Papa 12',6,'si',100.00),(24,'2019-11-29','2019-11-29','2019-11-29','2019-11-29','Entregada','REPARACIONES REALIZADAS - PRUEBA FINAL - MODIFICADA','REPARACIONES A REALIZAR - PRUEBA FINAL','OBSERVACIONES - PRUEBA FINAL','GCJ 523',1,'si',1501.00);
/*!40000 ALTER TABLE `reparaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repuestos`
--

DROP TABLE IF EXISTS `repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `repuestos` (
  `cod_repuesto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio` decimal(10,2) unsigned NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`cod_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuestos`
--

LOCK TABLES `repuestos` WRITE;
/*!40000 ALTER TABLE `repuestos` DISABLE KEYS */;
INSERT INTO `repuestos` VALUES (24,'Foco delantero',25.50,0),(25,'Guardabarro delantero',3300.00,6),(26,'Optica delantera',3450.00,6),(27,'Motor limpiaparabrisas - Palio 1.3',1340.00,2);
/*!40000 ALTER TABLE `repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `turnos` (
  `nro_turno` int(11) NOT NULL,
  `fecha_turno` date NOT NULL,
  `fecha_cancelacion` date DEFAULT NULL,
  `dni` int(11) NOT NULL,
  PRIMARY KEY (`nro_turno`),
  KEY `fk_turnos_clientes_idx` (`dni`),
  CONSTRAINT `fk_turnos_clientes` FOREIGN KEY (`dni`) REFERENCES `clientes` (`dni`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnos`
--

LOCK TABLES `turnos` WRITE;
/*!40000 ALTER TABLE `turnos` DISABLE KEYS */;
/*!40000 ALTER TABLE `turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tpjava'
--

--
-- Dumping routines for database 'tpjava'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-29 17:42:37
