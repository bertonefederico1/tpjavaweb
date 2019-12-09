-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: tpjava
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autos` (
  `patente` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `marca` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `modelo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `anio_fabricacion` int(10) unsigned DEFAULT NULL,
  `cantidad_km` int(10) unsigned DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `activo` varchar(42) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
INSERT INTO `autos` VALUES ('ABC345','Honda','Fit',2018,13450,40121097,'no'),('BCH 471','Fiat','Palio',2005,54000,40121097,'no'),('HJK 999','Ford ','Falcon',1985,300000,37817242,'si');
/*!40000 ALTER TABLE `autos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `dni` int(11) NOT NULL,
  `nombre_y_apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (37817242,'Federico Bertone','Catamarca 1431','bertonefederico1@gmail.com','3465535153','si'),(40121097,'Andres Bertone','Entre Rios 2019','andresbertone@gmail.com','','si');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanicos`
--

DROP TABLE IF EXISTS `mecanicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanicos` (
  `matricula` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_y_apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contrasenia` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicos`
--

LOCK TABLES `mecanicos` WRITE;
/*!40000 ALTER TABLE `mecanicos` DISABLE KEYS */;
INSERT INTO `mecanicos` VALUES (1,'Hugo San','Saavedra 1050','huguito21@gmail.com','420927','1','si'),(6,'Alberto Marcovich','Sarmiento 1987','','456123','6','si');
/*!40000 ALTER TABLE `mecanicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `politicas_organizacion`
--

DROP TABLE IF EXISTS `politicas_organizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `politicas_organizacion` (
  `fecha_desde` date NOT NULL,
  `turnos_max_por_dia` int(11) DEFAULT NULL,
  `stock_minimo` int(11) DEFAULT NULL,
  PRIMARY KEY (`fecha_desde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `politicas_organizacion`
--

LOCK TABLES `politicas_organizacion` WRITE;
/*!40000 ALTER TABLE `politicas_organizacion` DISABLE KEYS */;
INSERT INTO `politicas_organizacion` VALUES ('2019-12-02',4,3);
/*!40000 ALTER TABLE `politicas_organizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provee`
--

DROP TABLE IF EXISTS `provee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provee` (
  `cod_repuesto` int(10) unsigned NOT NULL,
  `cuit` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `cuit` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `razon_social` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `activo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('20-37817454-1','COMON S.A','4219999','comonsa@gmail.com','Alberdi 1212','si'),('21-37897099-1','Pepito S.R.L','15657892','pepin65@yahoo.com','san martin 1200','si');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repa_repuestos`
--

DROP TABLE IF EXISTS `repa_repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
INSERT INTO `repa_repuestos` VALUES (25,24,2),(26,24,2),(26,25,1),(26,27,2),(28,24,1);
/*!40000 ALTER TABLE `repa_repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparaciones`
--

DROP TABLE IF EXISTS `reparaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reparaciones` (
  `nro_reparacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` date NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `estado` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion_final` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `detalle_inicial` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `observaciones` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `patente` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `matricula` int(11) unsigned DEFAULT NULL,
  `activa` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mano_de_obra` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`nro_reparacion`),
  KEY `fk_reparaciones_mecanicos_idx` (`matricula`),
  KEY `fk_reparaciones_autos_idx` (`patente`),
  CONSTRAINT `fk_reparaciones_autos` FOREIGN KEY (`patente`) REFERENCES `autos` (`patente`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_reparaciones_mecanicos` FOREIGN KEY (`matricula`) REFERENCES `mecanicos` (`matricula`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparaciones`
--

LOCK TABLES `reparaciones` WRITE;
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` VALUES (25,'2019-12-02','2019-12-02','2019-12-02','2019-12-02','Entregada','Cambio de los 2 focos delanteros','Cambiar los 2 focos delanteros','Puerta trasera izquierda rayada','ABC345',1,'si',200.00),(26,'2019-12-02','2019-12-02','2019-12-03',NULL,'Finalizada','Se cambió el guardabarro pedido y se revisó presión de las cubiertas','colocar guardabarro delantero derecho','','HJK 999',1,'si',450.00),(27,'2019-12-02',NULL,NULL,NULL,'Ingresada',NULL,'cambiar:\r\n- motor del limpiaparabrisas\r\n- óptica delantera izquierda\r\n','Espejo lateral izquierdo rayado','BCH 471',NULL,'si',NULL),(28,'2019-12-02','2019-12-02',NULL,NULL,'En curso','xfcdfggh','a realiafaf','sdfsdsdf','BCH 471',1,'si',111.00);
/*!40000 ALTER TABLE `reparaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repuestos`
--

DROP TABLE IF EXISTS `repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repuestos` (
  `cod_repuesto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio` decimal(10,2) unsigned NOT NULL,
  `stock` int(11) NOT NULL,
  `activo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuestos`
--

LOCK TABLES `repuestos` WRITE;
/*!40000 ALTER TABLE `repuestos` DISABLE KEYS */;
INSERT INTO `repuestos` VALUES (24,'Foco delantero',25.50,5,'si'),(25,'Guardabarro delantero',3300.00,3,'si'),(26,'Optica delantera',3450.00,6,'si'),(27,'Motor limpiaparabrisas - Palio 1.3',1340.00,0,'si');
/*!40000 ALTER TABLE `repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turnos` (
  `nro_turno` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_turno` date NOT NULL,
  `fecha_cancelacion` date DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `estado` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nro_turno`),
  KEY `fk_turnos_clientes_idx` (`dni`),
  CONSTRAINT `fk_turnos_clientes` FOREIGN KEY (`dni`) REFERENCES `clientes` (`dni`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnos`
--

LOCK TABLES `turnos` WRITE;
/*!40000 ALTER TABLE `turnos` DISABLE KEYS */;
INSERT INTO `turnos` VALUES (1,'2019-12-22',NULL,40121097,'En espera'),(6,'2019-12-22','2019-12-22',37817242,'Cancelado'),(8,'2019-12-22',NULL,37817242,'En espera'),(9,'2019-12-21',NULL,40121097,'En espera'),(13,'2019-12-22',NULL,37817242,'En espera'),(14,'2019-12-22',NULL,40121097,'En espera');
/*!40000 ALTER TABLE `turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tpjava'
--

--
-- Dumping routines for database 'tpjava'
--
/*!50003 DROP PROCEDURE IF EXISTS `disponibilidad_turnos_a_la_fecha` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `disponibilidad_turnos_a_la_fecha`(in fecha date)
BEGIN
	select max(fecha_desde) into @ult_fecha
	from politicas_organizacion
	where fecha_desde <= current_date();

	select count(*) into @cant_turnos
	from turnos
	where fecha_turno = fecha and fecha_cancelacion is null and estado like '%En espera%';

	select if(@cant_turnos < turnos_max_por_dia, "si", "no") 'disponible'
	from politicas_organizacion
	where fecha_desde = @ult_fecha;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rep_stock_minimo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `rep_stock_minimo`()
BEGIN
select max(fecha_desde) into @ult_fecha
from politicas_organizacion
where fecha_desde <= current_date();

select stock_minimo into @stock_min
from politicas_organizacion po
where fecha_desde = @ult_fecha;

select * from repuestos
where stock <= @stock_min AND activo = "si";
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09 12:16:27
