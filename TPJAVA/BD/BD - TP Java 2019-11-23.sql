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
INSERT INTO `autos` VALUES ('EVL 687','Honda','Fit',2018,10000,37817242),('GCJ 523','Ford','Mondeo',2019,34700,41091000),('HCK 456','Ford','Falcon',1986,190000,40121987),('IPC 102','Honda','City',2017,19000,37817242);
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
INSERT INTO `clientes` VALUES (37817242,'Juan Perez','mitre 1234','','420222'),(40121097,'Francisco 1','Entre Rios 2019','','346515520237'),(40121987,'Elsa Lame','catamarca 1236','elsa21@gmail.com','155422123'),(41091000,'Esteban Quito','san juan 1287','esteban.quito@hotmail.com','425678');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicos`
--

LOCK TABLES `mecanicos` WRITE;
/*!40000 ALTER TABLE `mecanicos` DISABLE KEYS */;
INSERT INTO `mecanicos` VALUES (1,'Hugo Salomon','san juan 1287','huguito13@gmail.com','421090','1'),(2,'Alberto San','Richieri 678 Bis','','','2');
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
INSERT INTO `proveedores` VALUES ('20-37817454-1','COMON S.A','423456','comonsa@gmail.com','Alberdi 1212'),('21-37897099-1','Pepito S.R.L','15657892','pepin65@yahoo.com','san martin 1200');
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
INSERT INTO `repa_repuestos` VALUES (8,4,2),(8,8,1),(11,8,1),(14,2,1),(14,4,1),(15,2,1),(15,4,2),(15,8,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparaciones`
--

LOCK TABLES `reparaciones` WRITE;
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` VALUES (8,'2019-09-17','2019-11-12','2019-11-21','2019-11-21','Entregada','sssssss','cambiar foco delantero','puerta derecha rayada','HCK 456',2,'si',1000.00),(9,'2019-04-16',NULL,NULL,NULL,'Ingresada',NULL,'Reparar amortiguador delantero',NULL,'IPC 102',1,'no',NULL),(11,'2019-09-24','2019-11-23','2019-11-23','2019-11-23','Entregada','fffff','test',NULL,'GCJ 523',1,'si',33.00),(13,'2019-10-09',NULL,NULL,NULL,'Ingresada',NULL,'Cambiar amortiguador izquierdo',NULL,'IPC 102',NULL,'si',NULL),(14,'2019-10-09','2019-11-21','2019-11-21','2019-11-21','Entregada','dd','cambio de aceite',NULL,'HCK 456',2,'si',123.00),(15,'2019-10-09','2019-11-12','2019-11-12','2019-11-21','Entregada','Prueba ','sdfsdf',NULL,'HCK 456',1,'si',100.00),(16,'2019-10-09',NULL,NULL,NULL,'Ingresada',NULL,'asd',NULL,'IPC 102',NULL,'si',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuestos`
--

LOCK TABLES `repuestos` WRITE;
/*!40000 ALTER TABLE `repuestos` DISABLE KEYS */;
INSERT INTO `repuestos` VALUES (2,'Foco Delantero',10.79,7),(3,'Guardabarro de falcon',4000.20,7),(4,'Amoritguador Trasero',3240.00,1),(8,'Capot',222.00,4);
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

-- Dump completed on 2019-11-23 11:02:26
