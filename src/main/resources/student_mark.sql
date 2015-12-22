-- phpMyAdmin SQL Dump
-- version 4.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2015-07-21 11:46:40
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
-- 表的结构 `student_mark`
--

CREATE TABLE IF NOT EXISTS `student_mark` (
`id` int(11) NOT NULL COMMENT '自增',
  `sid` int(11) NOT NULL COMMENT '学生id',
  `term` tinyint(4) NOT NULL COMMENT '学期',
  `grade` char(50) NOT NULL COMMENT '年级',
  `major` char(100) NOT NULL COMMENT '专业或班级',
  `course_id` smallint(6) NOT NULL COMMENT '学科id',
  `course_name` char(50) NOT NULL COMMENT '学科名称',
  `score` tinyint(4) NOT NULL COMMENT '得分'
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `student_mark`
--

INSERT INTO `student_mark` (`id`, `sid`, `term`, `grade`, `major`, `course_id`, `course_name`, `score`) VALUES
(1, 2012123654, 6, '大三下学期', '电子信息工程系08-01班', 1002, '电子线路', 26);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_mark`
--
ALTER TABLE `student_mark`
 ADD PRIMARY KEY (`id`), ADD KEY `course_id` (`course_id`), ADD KEY `course_name` (`course_name`), ADD KEY `term` (`term`), ADD KEY `grade` (`grade`), ADD KEY `sid` (`sid`), ADD KEY `sid_2` (`sid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_mark`
--
ALTER TABLE `student_mark`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
