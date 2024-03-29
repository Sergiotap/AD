-- phpMyAdmin SQL Dump
-- version 2.11.3
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-02-2012 a las 13:24:04
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de datos: `bdemp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dept`
--

DROP TABLE IF EXISTS dept;
CREATE TABLE IF NOT EXISTS dept (
    DEPTNO int(2) NOT NULL,
    DNAME varchar(14) default NULL,
    LOC varchar(13) default NULL,
    PRIMARY KEY (DEPTNO)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `dept`
--

INSERT INTO dept (DEPTNO, DNAME, LOC) VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emp`
--

DROP TABLE IF EXISTS emp;
CREATE TABLE IF NOT EXISTS emp (
    EMPNO int(4) NOT NULL,
    ENAME varchar(10) default NULL,
    JOB varchar(9) default NULL,
    MGR int(4) default NULL,
    HIREDATE date default NULL,
    SAL decimal(7,2) default NULL,
    COMM decimal(7,2) default NULL,
    DEPTNO int(2) NOT NULL,
    PRIMARY KEY  (EMPNO),
    KEY EMP_FOREIGN_KEY (DEPTNO)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `emp`
--

INSERT INTO emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES
(7839, 'KING', 'PRESIDENT', 0, '1981-11-17', 5000.00, 0.00, 10),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, 0.00, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, 0.00, 10),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, 0.00, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-04-02', 1250.00, 1400.00, 30),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, 0.00, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250.00, 500.00, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, 0.00, 20),
(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800.00, 0.00, 20),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000.00, 0.00, 20),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1100.00, 0.00, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, 0.00, 10);
