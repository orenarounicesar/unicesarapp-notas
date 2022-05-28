/*
 Navicat Premium Data Transfer

 Source Server         : Develop
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : claro.aprehsiltda.com:3308
 Source Schema         : unicesarappdb

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 28/05/2022 01:25:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for asignaturas
-- ----------------------------
DROP TABLE IF EXISTS `asignaturas`;
CREATE TABLE `asignaturas` (
  `codigo_asignatura` smallint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_asignatura` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigo_asignatura`),
  KEY `nombre_asignatura` (`nombre_asignatura`),
  KEY `activo` (`activo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of asignaturas
-- ----------------------------
BEGIN;
INSERT INTO `asignaturas` VALUES (1, 'PROGRAMACION ORIENTADA A OBJETOS', b'1');
INSERT INTO `asignaturas` VALUES (2, 'ESTRUCTURAS DE DATOS', b'1');
INSERT INTO `asignaturas` VALUES (3, 'CALCULO DIFERENCIAL ', b'1');
INSERT INTO `asignaturas` VALUES (4, 'AUDITORIA DE SISTEMAS ', b'1');
INSERT INTO `asignaturas` VALUES (5, 'INGLES ', b'1');
COMMIT;

-- ----------------------------
-- Table structure for cortes
-- ----------------------------
DROP TABLE IF EXISTS `cortes`;
CREATE TABLE `cortes` (
  `codigo_corte` smallint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_corte` varchar(255) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `porcentaje` tinyint NOT NULL,
  `ultimo_corte` bit(1) NOT NULL DEFAULT b'0',
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`codigo_corte`),
  KEY `porcentaje` (`porcentaje`),
  KEY `activo` (`activo`),
  KEY `nombre_corte` (`nombre_corte`),
  KEY `ultimo_corte` (`ultimo_corte`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of cortes
-- ----------------------------
BEGIN;
INSERT INTO `cortes` VALUES (1, 'Primer Corte', 30, b'0', b'1');
INSERT INTO `cortes` VALUES (2, 'Segundo Corte', 30, b'0', b'1');
INSERT INTO `cortes` VALUES (3, 'Final', 40, b'1', b'1');
COMMIT;

-- ----------------------------
-- Table structure for cortes_fechas
-- ----------------------------
DROP TABLE IF EXISTS `cortes_fechas`;
CREATE TABLE `cortes_fechas` (
  `codigo_corte_fecha` smallint unsigned NOT NULL AUTO_INCREMENT,
  `codigo_corte` smallint unsigned NOT NULL,
  `semestre` tinyint NOT NULL DEFAULT '1',
  `fecha` datetime NOT NULL,
  `actual` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigo_corte_fecha`),
  UNIQUE KEY `codigo_corte` (`codigo_corte`,`semestre`,`fecha`),
  KEY `actual` (`actual`),
  CONSTRAINT `cortes_fechas_ibfk_2` FOREIGN KEY (`codigo_corte`) REFERENCES `cortes` (`codigo_corte`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of cortes_fechas
-- ----------------------------
BEGIN;
INSERT INTO `cortes_fechas` VALUES (1, 1, 1, '2021-10-09 23:59:59', b'1');
INSERT INTO `cortes_fechas` VALUES (2, 2, 1, '2021-11-23 23:59:59', b'0');
INSERT INTO `cortes_fechas` VALUES (3, 3, 1, '2021-12-18 23:59:59', b'0');
COMMIT;

-- ----------------------------
-- Table structure for datos_personales
-- ----------------------------
DROP TABLE IF EXISTS `datos_personales`;
CREATE TABLE `datos_personales` (
  `codigo_dato_personal` int unsigned NOT NULL AUTO_INCREMENT,
  `tipo_id` enum('CC','CE','PA','PE') COLLATE latin1_spanish_ci NOT NULL,
  `id` varchar(16) COLLATE latin1_spanish_ci NOT NULL,
  `nombre1` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `nombre2` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `apellido1` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `apellido2` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`codigo_dato_personal`),
  KEY `tipo_id` (`tipo_id`),
  KEY `id` (`id`),
  KEY `nombre1` (`nombre1`),
  KEY `nombre2` (`nombre2`),
  KEY `apellido1` (`apellido1`),
  KEY `apellido2` (`apellido2`),
  KEY `fecha_nacimiento` (`fecha_nacimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of datos_personales
-- ----------------------------
BEGIN;
INSERT INTO `datos_personales` VALUES (1, 'CC', '85488140', 'ORLANDO', 'ENRIQUE', 'ARRIETA', 'RODRIGUEZ', '1981-03-16', 'CARRERA 14 # 13 B BIS - 04', '3017793384', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (2, 'CC', '1065622133', 'SUSANA ', 'MARIA', 'OROZCO', 'PEREZ', '1990-01-01', 'CRA 7# 21- 20', '3002002345', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (3, 'CC', '1065332098', 'JOSE ', NULL, 'AVENDAÑO', 'DUARTE', '1983-04-12', 'CALLE 21 #4-06', '3002312455', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (4, 'CC', '1067901099', 'VICTOR', 'HUGO', 'SUAREZ', 'BONILLA', '1983-06-08', 'CRA 25 #20-33', '3042445688', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (5, 'CC', '10674562311', 'MARIA', 'VICTORIA', 'PAEZ', 'CUADRADO', '2000-08-08', 'MZA 2 CASA 23', '3024327644', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (6, 'CC', '1065622099', 'KEYLA', 'ANDREA', 'CASTILLO', 'FERNANDEZ', '1990-08-17', 'CARRERA 7 # 39-50', '3004238999', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (7, 'CC', '1065601967', 'RAFAEL', 'RICARDO', 'GUERRA ', 'MENDOZA', '2001-05-10', 'CRA 9 # 45-01', '3026785501', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (8, 'CC', '10676345231', 'JORGE', 'MARIO', 'CASTRO', 'PEDROZA', '1986-06-09', 'MZA 8 CASA 41-01', '3045678821', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (9, 'CC', '10657765499', 'MARIA', 'VALENTINA', 'GARCIA', 'RODRIGUEZ', '1999-12-01', 'CALLE 12 #56-02', '3078903211', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (10, 'CC', '10675634723', 'VANESA', NULL, 'CARCAMO ', 'MARTINEZ', '1985-07-03', 'CRA 4 #21-67', '3023315679', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (11, 'CC', '10656008721', 'JUAN', 'ALEJANDRO', 'MUÑOZ', 'CATAÑO', '1980-10-10', 'CALLE 8 #22-10', '3104235541', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (12, 'CC', '10654324101', 'RAFAEL', 'VICENTE', 'FERNANDEZ', 'LOPEZ', '2001-12-12', 'MZA 4 2 BIS 04', '3125012378', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (13, 'CC', '10678875634', 'LICETH', 'PATRICIA', 'GOMEZ', 'PEREZ', '1977-04-08', 'CALLE 14# 8-45', '3045678921', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (14, 'CC', '10643567790', 'VICTORIA', NULL, 'HERNANDEZ', 'APARICIO ', '1998-07-09', 'TRANSV 12 #43-09', '3145673244', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (15, 'CC', '10657890072', 'KATERIN ', 'MARIA', 'SUAREZ ', 'GUERRA ', '1997-09-10', 'CONJUNTO MARIAS ', '3156782314', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (16, 'CC', '10645672341', 'ANTONELA', NULL, 'MENDOZA ', 'PEREZ', '1977-03-06', 'CRA 7 #45-02', '3214563377', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (17, 'CC', '1065677890', 'MARIA ', 'CELESTE ', 'BONILLA ', 'BONILLA', '1992-04-01', 'CALLE 56 # 54-12', '3215673211', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (18, 'CC', '1067324991', 'ANDRES', NULL, 'MAESTRE ', 'SANCHEZ', '1985-07-09', 'TRANSV 4 CASA 21-21 ', '3224538900', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (19, 'CC', '10645327785', 'WILSON', 'DARIO ', 'RESTREPO ', 'GONZALEZ', '1970-12-12', 'CALLE 72 #21-45', '3149807751', 'orenaro@gmail.com');
INSERT INTO `datos_personales` VALUES (20, 'CC', '10674560901', 'GERMAN ', 'JOSE ', 'MARTINEZ', 'GARCIA ', '1995-09-07', 'CRA 4 # 56-78', '3214408976', 'german.martinez@unicesar.edu.co');
COMMIT;

-- ----------------------------
-- Table structure for docentes
-- ----------------------------
DROP TABLE IF EXISTS `docentes`;
CREATE TABLE `docentes` (
  `codigo_docente` smallint unsigned NOT NULL AUTO_INCREMENT,
  `codigo_dato_personal` int unsigned NOT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigo_docente`),
  KEY `activo` (`activo`),
  KEY `codigo_dato_personal` (`codigo_dato_personal`),
  CONSTRAINT `docentes_ibfk_1` FOREIGN KEY (`codigo_dato_personal`) REFERENCES `datos_personales` (`codigo_dato_personal`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of docentes
-- ----------------------------
BEGIN;
INSERT INTO `docentes` VALUES (1, 1, b'1');
INSERT INTO `docentes` VALUES (2, 3, b'1');
INSERT INTO `docentes` VALUES (3, 4, b'1');
INSERT INTO `docentes` VALUES (4, 8, b'1');
INSERT INTO `docentes` VALUES (5, 13, b'1');
INSERT INTO `docentes` VALUES (6, 16, b'1');
INSERT INTO `docentes` VALUES (7, 18, b'1');
COMMIT;

-- ----------------------------
-- Table structure for docentes_asignaturas
-- ----------------------------
DROP TABLE IF EXISTS `docentes_asignaturas`;
CREATE TABLE `docentes_asignaturas` (
  `codigo_docente_asignatura` int unsigned NOT NULL AUTO_INCREMENT,
  `codigo_docente` smallint unsigned NOT NULL,
  `codigo_asignatura` smallint unsigned NOT NULL,
  PRIMARY KEY (`codigo_docente_asignatura`),
  UNIQUE KEY `codigo_docente` (`codigo_docente`,`codigo_asignatura`),
  KEY `codigo_asignatura` (`codigo_asignatura`),
  CONSTRAINT `docentes_asignaturas_ibfk_1` FOREIGN KEY (`codigo_docente`) REFERENCES `docentes` (`codigo_docente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `docentes_asignaturas_ibfk_2` FOREIGN KEY (`codigo_asignatura`) REFERENCES `asignaturas` (`codigo_asignatura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of docentes_asignaturas
-- ----------------------------
BEGIN;
INSERT INTO `docentes_asignaturas` VALUES (1, 1, 1);
INSERT INTO `docentes_asignaturas` VALUES (2, 1, 2);
INSERT INTO `docentes_asignaturas` VALUES (3, 2, 3);
INSERT INTO `docentes_asignaturas` VALUES (4, 3, 4);
INSERT INTO `docentes_asignaturas` VALUES (5, 4, 1);
INSERT INTO `docentes_asignaturas` VALUES (6, 5, 5);
INSERT INTO `docentes_asignaturas` VALUES (7, 6, 4);
INSERT INTO `docentes_asignaturas` VALUES (8, 7, 3);
COMMIT;

-- ----------------------------
-- Table structure for estudiantes
-- ----------------------------
DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE `estudiantes` (
  `codigo_estudiante` int unsigned NOT NULL AUTO_INCREMENT,
  `codigo_universitario` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_dato_personal` int unsigned NOT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigo_estudiante`),
  KEY `codigo_universitario` (`codigo_universitario`),
  KEY `activo` (`activo`),
  KEY `codigo_dato_personal` (`codigo_dato_personal`),
  CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`codigo_dato_personal`) REFERENCES `datos_personales` (`codigo_dato_personal`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of estudiantes
-- ----------------------------
BEGIN;
INSERT INTO `estudiantes` VALUES (1, '20190101', 1, b'1');
INSERT INTO `estudiantes` VALUES (2, '20190102', 2, b'1');
INSERT INTO `estudiantes` VALUES (3, '20190103', 3, b'1');
INSERT INTO `estudiantes` VALUES (4, '20190104', 4, b'1');
INSERT INTO `estudiantes` VALUES (5, '20190105', 5, b'1');
INSERT INTO `estudiantes` VALUES (6, '20190106', 6, b'1');
INSERT INTO `estudiantes` VALUES (7, '20190107', 7, b'1');
INSERT INTO `estudiantes` VALUES (8, '20190108', 8, b'1');
INSERT INTO `estudiantes` VALUES (9, '20190109', 9, b'1');
INSERT INTO `estudiantes` VALUES (10, '20190110', 10, b'1');
INSERT INTO `estudiantes` VALUES (11, '20190111', 11, b'1');
INSERT INTO `estudiantes` VALUES (12, '20190112', 12, b'1');
INSERT INTO `estudiantes` VALUES (13, '20190113', 13, b'1');
INSERT INTO `estudiantes` VALUES (14, '20190114', 14, b'1');
INSERT INTO `estudiantes` VALUES (15, '20190115', 15, b'1');
INSERT INTO `estudiantes` VALUES (16, '20190116', 16, b'1');
INSERT INTO `estudiantes` VALUES (17, '20190117', 17, b'1');
INSERT INTO `estudiantes` VALUES (18, '20190118', 18, b'1');
INSERT INTO `estudiantes` VALUES (19, '20190119', 19, b'1');
COMMIT;

-- ----------------------------
-- Table structure for estudiantes_asignaturas
-- ----------------------------
DROP TABLE IF EXISTS `estudiantes_asignaturas`;
CREATE TABLE `estudiantes_asignaturas` (
  `codigo_estudiante_asignatura` int unsigned NOT NULL AUTO_INCREMENT,
  `codigo_estudiante` int unsigned NOT NULL,
  `codigo_asignatura` smallint unsigned NOT NULL,
  PRIMARY KEY (`codigo_estudiante_asignatura`),
  UNIQUE KEY `codigo_estudiante` (`codigo_estudiante`,`codigo_asignatura`),
  KEY `codigo_asignatura` (`codigo_asignatura`),
  CONSTRAINT `estudiantes_asignaturas_ibfk_1` FOREIGN KEY (`codigo_estudiante`) REFERENCES `estudiantes` (`codigo_estudiante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `estudiantes_asignaturas_ibfk_2` FOREIGN KEY (`codigo_asignatura`) REFERENCES `asignaturas` (`codigo_asignatura`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of estudiantes_asignaturas
-- ----------------------------
BEGIN;
INSERT INTO `estudiantes_asignaturas` VALUES (1, 1, 1);
INSERT INTO `estudiantes_asignaturas` VALUES (2, 2, 1);
INSERT INTO `estudiantes_asignaturas` VALUES (3, 3, 1);
INSERT INTO `estudiantes_asignaturas` VALUES (4, 4, 1);
INSERT INTO `estudiantes_asignaturas` VALUES (5, 5, 2);
INSERT INTO `estudiantes_asignaturas` VALUES (6, 6, 3);
INSERT INTO `estudiantes_asignaturas` VALUES (7, 7, 3);
INSERT INTO `estudiantes_asignaturas` VALUES (8, 8, 4);
INSERT INTO `estudiantes_asignaturas` VALUES (9, 9, 5);
INSERT INTO `estudiantes_asignaturas` VALUES (10, 10, 2);
INSERT INTO `estudiantes_asignaturas` VALUES (15, 11, 5);
INSERT INTO `estudiantes_asignaturas` VALUES (16, 12, 2);
INSERT INTO `estudiantes_asignaturas` VALUES (17, 13, 4);
INSERT INTO `estudiantes_asignaturas` VALUES (18, 14, 4);
INSERT INTO `estudiantes_asignaturas` VALUES (19, 15, 2);
INSERT INTO `estudiantes_asignaturas` VALUES (21, 16, 2);
INSERT INTO `estudiantes_asignaturas` VALUES (22, 17, 5);
INSERT INTO `estudiantes_asignaturas` VALUES (23, 18, 3);
INSERT INTO `estudiantes_asignaturas` VALUES (24, 19, 1);
COMMIT;

-- ----------------------------
-- Table structure for notas
-- ----------------------------
DROP TABLE IF EXISTS `notas`;
CREATE TABLE `notas` (
  `codigo_nota` int unsigned NOT NULL AUTO_INCREMENT,
  `codigo_estudiante_asignatura` int unsigned NOT NULL,
  `codigo_corte` smallint unsigned NOT NULL,
  `nota` float NOT NULL,
  `publicada` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`codigo_nota`),
  UNIQUE KEY `codigo_estudiante_asignatura` (`codigo_estudiante_asignatura`,`codigo_corte`),
  KEY `nota` (`nota`),
  KEY `publicada` (`publicada`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of notas
-- ----------------------------
BEGIN;
INSERT INTO `notas` VALUES (1, 3, 1, 3.5, b'1');
INSERT INTO `notas` VALUES (4, 1, 1, 2.5, b'1');
INSERT INTO `notas` VALUES (7, 24, 1, 3.5, b'1');
INSERT INTO `notas` VALUES (10, 16, 1, 4, b'0');
INSERT INTO `notas` VALUES (12, 21, 1, 4, b'0');
INSERT INTO `notas` VALUES (16, 2, 1, 2.5, b'1');
INSERT INTO `notas` VALUES (17, 4, 1, 4.6, b'1');
INSERT INTO `notas` VALUES (18, 10, 1, 3.5, b'0');
INSERT INTO `notas` VALUES (23, 5, 1, 2.5, b'0');
INSERT INTO `notas` VALUES (24, 19, 1, 3.5, b'0');
COMMIT;

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `codigo_usuario` smallint unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `nombre_usuario` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_docente` smallint unsigned DEFAULT NULL,
  `codigo_estudiante` int unsigned DEFAULT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigo_usuario`),
  KEY `login` (`login`),
  KEY `nombre_usuario` (`nombre_usuario`),
  KEY `activo` (`activo`),
  KEY `codigo_docente` (`codigo_docente`),
  KEY `codigo_estudiante` (`codigo_estudiante`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`codigo_docente`) REFERENCES `docentes` (`codigo_docente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`codigo_estudiante`) REFERENCES `estudiantes` (`codigo_estudiante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
BEGIN;
INSERT INTO `usuarios` VALUES (1, 'orlando', '2ba7f2a9767d5b87ad9bb0de703b16e4', 'ORLANDO ARRIETA', 1, NULL, b'1');
INSERT INTO `usuarios` VALUES (2, 'susana', '2ba7f2a9767d5b87ad9bb0de703b16e4', 'SUSANA', NULL, 2, b'1');
INSERT INTO `usuarios` VALUES (3, 'orenaro', '2ba7f2a9767d5b87ad9bb0de703b16e4', 'ORLANDO ARRIETA', 1, NULL, b'1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
