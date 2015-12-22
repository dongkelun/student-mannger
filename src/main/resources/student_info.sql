-- phpMyAdmin SQL Dump
-- version 4.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2015-07-21 11:46:35
-- 服务器版本： 5.5.37-MariaDB-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- 表的结构 `student_info`
--

CREATE TABLE IF NOT EXISTS `student_info` (
  `sid` int(11) NOT NULL COMMENT '学生id',
  `name` char(50) NOT NULL COMMENT '学生姓名',
  `birthday` char(10) NOT NULL COMMENT '生日',
  `gender` char(10) NOT NULL COMMENT '性别',
  `age` tinyint(4) NOT NULL COMMENT '年龄',
  `resume` text NOT NULL COMMENT '简历情况',
  `awards` text NOT NULL COMMENT '获得奖励情况',
  `penality` text NOT NULL COMMENT '收到处分情况',
  `home` text NOT NULL COMMENT '学生家庭情况',
  `medical` text NOT NULL COMMENT '学生体检情况'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
 ADD UNIQUE KEY `sid` (`sid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
