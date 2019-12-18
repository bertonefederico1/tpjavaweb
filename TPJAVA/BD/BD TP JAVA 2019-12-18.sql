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
INSERT INTO `autos` VALUES ('AA 590 JL','Honda ','City ',2016,85000,14205920,'si'),('AB 102 CC','Fiat','Palio',2005,45400,40121345,'si'),('EVL 909','Ford','Focus',2015,50000,37817242,'si'),('GCJ 523','Honda ','Fit',2018,13300,40121097,'si'),('GGG 222','Chevrolet','Cruze',2018,123,40121097,'si');
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
INSERT INTO `clientes` VALUES (12999002,'Maria rosa Alvarez','Calle 134 - 3A','alvarezm@gmail.com','3414212143','si'),(14205920,'Elsa Savio','Tucuman 1900','elsita999@hotmail.com','3414356987','si'),(20900472,'Federico Alarcon','Juan B Justo 1748','fede2392@hotmail.com','3414256786','si'),(24987790,'Martin Sanchez','Alberdi 1222','tincho222@gmail.com','','si'),(37817242,'Federico Bertone','Catamarca 1488','fede_gg_21@hotmail.com','3465526678','si'),(40121097,'Andres Bertone','Salta 1400','andresbertone97@gmail.com','346515520237','si'),(40121345,'Juan Perez','Entre rios 1288','juan21@gmail.com','3465424541','si');
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
  `nombre_y_apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefono` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicos`
--

LOCK TABLES `mecanicos` WRITE;
/*!40000 ALTER TABLE `mecanicos` DISABLE KEYS */;
INSERT INTO `mecanicos` VALUES (21,'Alberto San','Saavedra 678','','','si'),(22,'Martin Gomez','San Martin 1789','gomez21_@gmail.com','3414214213','si'),(23,'Ricardo Centurion','Montevideo 256','','346815669874','si');
/*!40000 ALTER TABLE `mecanicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `politicas_organizacion`
--

DROP TABLE IF EXISTS `politicas_organizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `provee` (
  `cod_repuesto` int(10) unsigned NOT NULL,
  `cuit` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_repuesto`,`cuit`),
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
INSERT INTO `provee` VALUES (40,'22-42423423-5'),(41,'22-42423423-5'),(42,'21-37817231-5'),(44,'22-42423423-5'),(45,'20-37817242-4'),(46,'20-37817242-4'),(47,'21-37817231-5'),(48,'20-37817242-4'),(49,'20-37817242-4'),(50,'22-42423423-5'),(51,'20-37817242-4');
/*!40000 ALTER TABLE `provee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
INSERT INTO `proveedores` VALUES ('20-37817242-4','SCYZORIK S.R.L','3414215672','scyzorik@scizorik.com.ar','Ruta 8 km 1399','si'),('21-37817231-5','Comon S.A','3414256789','comonsa@gmail.com','San Juan 1244','si'),('22-42423423-5','Mercomax S.A','3414256579','merco@merco.com','Alvear 2555','si');
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
INSERT INTO `repa_repuestos` VALUES (34,40,2),(34,51,1),(35,40,1),(36,47,1),(37,42,1),(37,48,1),(37,51,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparaciones`
--

LOCK TABLES `reparaciones` WRITE;
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` VALUES (34,'2019-12-13','2019-12-18','2019-12-18','2019-12-18','Entregada','Se hizo cambio de los focos delanteros.\r\n\r\n','cambiar los dos focos delanteros','la puerta derecha esta rayada','GCJ 523',23,'si',1500.00),(35,'2019-12-18','2019-12-18','2019-12-18','2019-12-18','Entregada','se cambio el foco delantero izquierdo y carga de bateria','foco delantero izquierdo quemado, y no arranca','la puerta derecha esta rayada','AA 590 JL',21,'si',800.00),(36,'2019-12-18','2019-12-18','2019-12-18','2019-12-18','Entregada','','cambiar correas de distribucion','','AB 102 CC',23,'si',0.00),(37,'2019-12-18','2019-12-18','2019-12-18','2019-12-18','Entregada','Colocación de bomba de agua y cambio de aceite 10w40 con filtro','realizar service ','espejo retrovisor izquierdo roto\r\n','EVL 909',23,'si',750.00);
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
  `descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio` decimal(10,2) unsigned NOT NULL,
  `stock` int(11) NOT NULL,
  `activo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuestos`
--

LOCK TABLES `repuestos` WRITE;
/*!40000 ALTER TABLE `repuestos` DISABLE KEYS */;
INSERT INTO `repuestos` VALUES (40,'Foco delantero - Marcas varias',175.90,9,'si'),(41,'Optica trasera izquierda Fiat Palio ',3450.00,5,'si'),(42,'Bujias NGK Fiat Palio X4',1550.00,9,'si'),(44,'Limpia parabrisas X2 - Original',1400.00,10,'si'),(45,'Embrague Honda fit - Alternativo',15565.90,5,'si'),(46,'Kit distribucion Original - Fiat Palio 2005 - 2010',5800.00,10,'si'),(47,'Kit tornillos antirobo rueda - Honda Fit X16',2500.00,7,'si'),(48,'Bomba de agua Alternativa - Fiat Palio 2011 - 2015',2450.57,9,'si'),(49,'Radiador Honda City/Fit 2015 - 2019',9800.00,4,'si'),(50,'Cubre Volante - marcas varias',1400.30,15,'si'),(51,'Aceite 10w40 x 5 Litros + filtro de aceite',2800.00,7,'si');
/*!40000 ALTER TABLE `repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `turnos` (
  `nro_turno` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_turno` date NOT NULL,
  `fecha_cancelacion` date DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `estado` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`nro_turno`),
  KEY `fk_turnos_clientes_idx` (`dni`),
  CONSTRAINT `fk_turnos_clientes` FOREIGN KEY (`dni`) REFERENCES `clientes` (`dni`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnos`
--

LOCK TABLES `turnos` WRITE;
/*!40000 ALTER TABLE `turnos` DISABLE KEYS */;
INSERT INTO `turnos` VALUES (16,'2019-12-23',NULL,40121097,'En espera'),(17,'2019-12-18',NULL,37817242,'Ingresado'),(18,'2019-12-18',NULL,14205920,'Ingresado'),(22,'2019-12-18',NULL,12999002,'En espera'),(23,'2019-12-18',NULL,24987790,'En espera'),(24,'2019-12-19',NULL,14205920,'En espera');
/*!40000 ALTER TABLE `turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_y_contrasenia`
--

DROP TABLE IF EXISTS `usuario_y_contrasenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario_y_contrasenia` (
  `usuario` int(11) NOT NULL,
  `contrasenia` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nivel` int(2) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_y_contrasenia`
--

LOCK TABLES `usuario_y_contrasenia` WRITE;
/*!40000 ALTER TABLE `usuario_y_contrasenia` DISABLE KEYS */;
INSERT INTO `usuario_y_contrasenia` VALUES (5,'5',5),(21,'5',5),(22,'5',5),(23,'elricky',1);
/*!40000 ALTER TABLE `usuario_y_contrasenia` ENABLE KEYS */;
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
	where fecha_turno = fecha and fecha_cancelacion is null and estado in ('En espera', 'Ingresado');

	select if(@cant_turnos < turnos_max_por_dia, "si", "no") 'disponible'
	from politicas_organizacion
	where fecha_desde = @ult_fecha;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_provee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_provee`(in cuit varchar(100))
BEGIN
	select max(cod_repuesto) into @ult_repuesto
    from repuestos;
    
    insert into provee(cod_repuesto, cuit) values (@ult_repuesto, cuit);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserta_usuario_y_contrasenia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserta_usuario_y_contrasenia`(in contra varchar(45), in nivel int(2))
BEGIN
	select max(matricula) into @usuario
	from mecanicos;
	
    insert into usuario_y_contrasenia values (@usuario, contra, nivel);
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

-- Dump completed on 2019-12-18 10:55:26
