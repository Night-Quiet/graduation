/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 10.4.19-MariaDB : Database - graduation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`graduation` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `graduation`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id_comment` int(32) NOT NULL AUTO_INCREMENT,
  `id_question` int(32) DEFAULT NULL,
  `identify` text DEFAULT NULL,
  `id_user_main` int(32) DEFAULT NULL,
  `user_main` text DEFAULT NULL,
  `user_main_comment` text DEFAULT NULL,
  PRIMARY KEY (`id_comment`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comment` */

insert  into `comment`(`id_comment`,`id_question`,`identify`,`id_user_main`,`user_main`,`user_main_comment`) values (1,1,'学生',1,'hjc','评论与问题无关, 已被删除'),(2,1,'学生',1,'hjc','评论与问题无关, 已被删除'),(3,2,'学生',1,'hjc','枪毙枪毙'),(4,3,'教师',2,'hjc','我是一个好人,好人的好,好人的人'),(5,2,'学生',1,'hjc','我也是好人'),(6,2,'教师',2,'hjc','我也是好人'),(7,2,'教师',2,'hjc','一如江水向东流'),(8,2,'学生',3,'admin','孤帆远影碧空尽'),(9,2,'学生',3,'admin','评论与问题无关, 已被删除'),(10,4,'学生',1,'hjc','hello,我是好人'),(11,6,'学生',4,'student','只为了,能够变得更强'),(12,1,'学生',1,'hjc','评论与问题无关, 已被删除'),(13,3,'学生',1,'hjc','我是好人'),(14,2,'教师',2,'hjc','hello'),(15,1,'学生',1,'hjc','不重要'),(16,1,'学生',1,'hjc','重要'),(17,3,'学生',1,'hjc','我是好人'),(18,9,'学生',3,'admin','我记得余弦相似度是根据两个向量的点集和2-范式计算，但是具体公式我给忘了老师'),(19,9,'学生',1,'hjc','同学，我记得余弦相似度的计算是有前提的，即两个向量是等长的，并且非零，所以同学你直接这样问比较不妥'),(20,9,'学生',4,'student','我是好人，+我wx：h00000，我将告诉答案'),(21,9,'学生',7,'ssd','评论与问题无关, 已被删除'),(22,9,'学生',7,'ssd','我是刷狗'),(23,9,'学生',7,'ssd','我是刷狗'),(24,9,'学生',7,'ssd','我是刷狗'),(25,9,'学生',7,'ssd','我是刷狗'),(26,9,'学生',7,'ssd','评论与问题无关, 已被删除'),(27,9,'教师',2,'hjc','评论与问题无关, 已被删除'),(28,9,'教师',2,'hjc','别看，说的就是你ssd'),(29,9,'教师',2,'hjc','这应该是讨论学习的地方，而不是玩耍的地方'),(30,9,'学生',7,'ssd','不要意思，我不再刷了，对不起'),(31,9,'学生',7,'ssd','主要是玩一下，看一下这个系统的问题'),(32,9,'学生',7,'ssd','这么一看，还是不错的'),(33,8,'学生',1,'hjc','我不知道这是什么东西'),(34,10,'学生',1,'hjc','确实如此'),(35,12,'学生',1,'hjc','你好');

/*Table structure for table `detail` */

DROP TABLE IF EXISTS `detail`;

CREATE TABLE `detail` (
  `id_question` int(32) NOT NULL,
  `question` text DEFAULT NULL,
  `answer` text DEFAULT NULL,
  `q_pic1` text DEFAULT NULL,
  `q_pic2` text DEFAULT NULL,
  `q_pic3` text DEFAULT NULL,
  `a_pic1` text DEFAULT NULL,
  `a_pic2` text DEFAULT NULL,
  `a_pic3` text DEFAULT NULL,
  `a_video` text DEFAULT NULL,
  PRIMARY KEY (`id_question`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `detail` */

insert  into `detail`(`id_question`,`question`,`answer`,`q_pic1`,`q_pic2`,`q_pic3`,`a_pic1`,`a_pic2`,`a_pic3`,`a_video`) values (1,'我很疑惑,这个选择真的对吗,还是真的错吗,对错重要吗?','对错的确很重要','','','','','..\\uploads\\2022-03-11\\F5884712314C46A6A1439EB5F487A0F9_.jpg','','..\\uploads\\2022-03-11\\DCA2BDF7BC2F4B6EA96C8A4DFD2E9CAD_.mkv'),(2,'但是每次会过得更好,不是吗','确实如此，我也这么认为','','','','','..\\uploads\\2022-03-27\\5B9A7DD565444D7190CF8FAAF154CA0B_.jpg','','..\\uploads\\2022-03-27\\CFE2FCF601D14799877D293C83C12BB3_.mkv'),(3,'我希望真的对错是真的美好,不是逃避.','美好总会如期而至','..\\uploads\\2022-03-11\\B83761BEF15F46CE8E6565A2E07374B8_.jpg','','..\\uploads\\2022-03-11\\85D793872BCB4AFA9C6654AE8EAD84DD_.jpg','','','..\\uploads\\2022-03-11\\2556D02C52C441E7A99A52122D94676C_.jpg',''),(4,'该怎么去形容你最贴切,拿什么跟你作比较才算特别.对你的感觉,对你不太了解,只凭直觉,你想我在规则里束缚,却又想我像梦中琢磨不住.','','..\\uploads\\2022-03-11\\418139B72A3C45269C3E2CBAEBCFCEC2_.jpg','..\\uploads\\2022-03-11\\135A5D0BBA1D4ABD9049560A184AB13A_.jpg','..\\uploads\\2022-03-11\\92D97CBB38F44BB4A3CA068D3D368571_.jpg','','','',''),(5,'如果这都不算爱,我要怎么打死自己,为什么,要这样,要这么玩耍','','','','','','','',''),(6,'爱恨就在一瞬间,嘿嘿','','','','','','','',''),(7,'我是好人, 请同意我的说法吧, 谢谢啊, 我真的是好人啊','','','','','','','',''),(8,'不知道老师，余弦相似度是如何计算的，原理是什么，我真的不清楚啊，老师','','..\\uploads\\2022-03-29\\6494FF674A514E82B7915BB8F1E4EFF2_.jpg','','','','','',''),(9,'请问老师，余弦相似度是如何计算的，主要是余弦相似度这个方面我没怎么了解过原理','余弦相似度：两个同纬度向量的点积 / 根号(向量1长度*向量2长度)，其实这个可以通过百度获得，只需要输入关键词：“余弦相似度”','..\\uploads\\2022-03-29\\DB4FA70B0C7D46A6877F381318C8CD21_.jpg','','','','..\\uploads\\2022-04-06\\2E82D90AF88A40B18D5247E3DBFFAB67_.jpg','','..\\uploads\\2022-04-06\\951C2B67ABED4A158279781527CC1A23_.mkv'),(10,'矩阵不仅是表示多维数组，而且是表示图的重要工具，这样的说法正确吗？','','','','','','','',''),(11,'设有一个二维数组A[m][n]，假设A[0][0]存放位置在 644，A[2][2]存放位置在676，每个元素占一个空间，问A[3][3]存放的位置在（ ）。','','','','','','','',''),(12,'向一个长度为n的向量的第i个元素(1≤i≤n+1)之前插入一个元素时，需向后移动 () 个元素。','','','','','','','',''),(13,'数组作为函数参数传递的是（） 。','','','','','','','',''),(14,'对于长度为n的线性表，建立其对应的单链表的时间复杂度为（）。','','','','','','','',''),(15,'已知二维数组A[1: 4, 1: 6]采用列序为主序方式存储，每个元素占用4个存储单元，并且A[3，4]的存储地址为1234，元素A[1, 1]的存储地址是（）','','','','','','','',''),(16,'在32位机器上，char str[]=\"Hello\", sizeof(str) = ()','','','','','','','',''),(17,'数组Ｑ［ｎ］用来表示一个循环队列，ｆ为当前队列头元素的前一位置，ｒ为队尾元素的位置，假定队列中元素的个数小于ｎ，计算队列中元素的公式为（）。','','','','','','','',''),(18,'设有一个10阶对称矩阵A[10][10]，采用压缩存储方式按行将矩阵中的下三角部分的元素存入一维数组B[  ]中，A[0][0]存入B[0]中，则A[8][6]在B[  ]的（    ）位置。','','','','','','','',''),(19,'人','','','','','','','',''),(20,'你好','','','..\\uploads\\2022-04-22\\BA93627DDDC847C7AC8CF6A7DE7A2077_.webp','','','','',''),(21,'请问余弦相似度是如何计算的？','余弦相似性通过测量两个向量的夹角的余弦值来度量它们之间的相似性。 具体如图。如视频','..\\uploads\\2022-04-22\\19F2791B1C6743ABA7CAF75950627A2B_.webp','','','..\\uploads\\2022-04-22\\FDA854E669FF40B7A8EA352482799578_.png','','','..\\uploads\\2022-04-22\\A163E84C990C46DE80D3BE3D6168F4DB_.mp4'),(22,'余弦相似度是什么','','..\\uploads\\2022-04-22\\0A4109EA207248FC89D4CC9685924EAC_.webp','','','','','',''),(23,'余弦相似度是什么','余弦相似性通过测量两个向量的夹角的余弦值来度量它们之间的相似性。 具体如图。如视频','..\\uploads\\2022-04-22\\B49F8D47CFEC490489BCDC7C996A2090_.webp','','','..\\uploads\\2022-04-22\\2705799315EB44CEB41D1E4AF88113E0_.png','','','..\\uploads\\2022-04-22\\746F0AEAC5D440CE9666806BAFDAFDEB_.mp4'),(24,'余弦相似度','余弦相似性通过测量两个向量的夹角的余弦值来度量它们之间的相似性。 具体如图。如视频','..\\uploads\\2022-04-23\\A0FAA3C03F2A45F78F88EE8058242BDD_.webp','','','..\\uploads\\2022-04-23\\D2540A52F25B480E8F4058A8F30223DC_.png','','','..\\uploads\\2022-04-23\\8F95E120D9D94901A4BD8D5384C404B4_.mp4');

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id_question` int(32) NOT NULL AUTO_INCREMENT,
  `id_class` int(32) DEFAULT NULL,
  `id_user` int(32) DEFAULT NULL,
  `keyword` text DEFAULT NULL,
  `datenow` text DEFAULT NULL,
  PRIMARY KEY (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

/*Data for the table `question` */

insert  into `question`(`id_question`,`id_class`,`id_user`,`keyword`,`datenow`) values (1,1,1,'对错重要吗','2022-03-10'),(2,1,1,'但每次过后会更好','2022-03-10'),(3,1,1,'不是逃避.','2022-03-11'),(4,1,1,'却又想我像梦中琢磨不住.','2022-03-11'),(8,1,3,'老师','2022-03-29'),(9,1,3,'主要是余弦相似度这个方面我没怎么了解过原理','2022-03-29'),(10,1,4,'而且是表示图的重要工具','2022-03-29'),(11,1,4,'A[2][2]存放位置在676','2022-03-29'),(12,1,4,'向一个长度为n的向量的第i个元素(1≤i≤n+1)之前插入一个元素时','2022-03-29'),(13,1,4,'数组作为函数参数传递的是（）','2022-03-29'),(14,1,4,'建立其对应的单链表的时间复杂度为（）','2022-03-29'),(15,1,4,'元素A[1','2022-03-29'),(16,1,4,'sizeof(str) = ()','2022-03-29'),(18,1,4,'则A[8][6]在B[  ]的（    ）位置','2022-03-29'),(24,1,1,'余弦相似度','2022-04-23');

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id_reply` int(32) NOT NULL AUTO_INCREMENT,
  `id_comment` int(32) DEFAULT NULL,
  `identify` text DEFAULT NULL,
  `id_user_other` int(32) DEFAULT NULL,
  `user_other` text DEFAULT NULL,
  `user_other_reply` text DEFAULT NULL,
  PRIMARY KEY (`id_reply`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

/*Data for the table `reply` */

insert  into `reply`(`id_reply`,`id_comment`,`identify`,`id_user_other`,`user_other`,`user_other_reply`) values (1,1,'学生',1,'hjc','回复与问题无关, 已被删除'),(2,1,'学生',1,'hjc','我好像枪毙自己啊,这么难写啊'),(3,1,'学生',1,'hjc','回复与问题无关, 已被删除'),(4,2,'学生',1,'hjc','杀无赦'),(5,3,'学生',3,'admin','枪毙枪毙'),(6,3,'教师',2,'hjc','hello, 我是好人'),(7,3,'学生',1,'hjc','我也是好人'),(8,6,'教师',2,'hjc','好人一生一百零八胎'),(9,3,'教师',2,'hjc','人生如梦如梦令'),(10,8,'学生',3,'admin','唯见长江天际流'),(11,4,'学生',3,'admin','感动天,感动地,为什么感动不了你'),(12,6,'学生',3,'admin','我也这么认为'),(13,10,'学生',1,'hjc','我不信, 我才是好人'),(14,12,'学生',1,'hjc','回复与问题无关, 已被删除'),(15,4,'学生',1,'hjc','你真是牛'),(16,14,'教师',2,'hjc','我很好'),(17,18,'学生',3,'admin','我记得是cosθ，但是后面的忘了'),(18,19,'学生',1,'hjc','然后根据两个点饥计算，除与他们的向量长度的积的根号，我记得是这样的'),(19,20,'学生',4,'student','回复与问题无关, 已被删除'),(20,21,'学生',7,'ssd','我是刷狗'),(21,22,'教师',2,'hjc','再刷枪决'),(22,33,'学生',1,'hjc','大萨达'),(23,34,'学生',1,'hjc','我不认同'),(24,35,'学生',1,'hjc','你好');

/*Table structure for table `statistics` */

DROP TABLE IF EXISTS `statistics`;

CREATE TABLE `statistics` (
  `id_user` int(32) NOT NULL,
  `id_question` int(32) NOT NULL,
  `identify` int(32) DEFAULT NULL,
  `is_comment` int(32) DEFAULT 0,
  `is_reply` int(32) DEFAULT 0,
  PRIMARY KEY (`id_user`,`id_question`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `statistics` */

insert  into `statistics`(`id_user`,`id_question`,`identify`,`is_comment`,`is_reply`) values (1,1,0,1,1),(1,2,0,0,0),(1,3,0,1,1),(1,4,0,1,1),(1,5,0,0,0),(1,6,0,0,0),(1,8,0,1,1),(1,9,0,1,1),(1,10,0,1,1),(1,12,0,1,1),(1,13,0,0,0),(1,20,0,0,0),(1,21,0,0,0),(1,22,0,0,0),(1,23,0,0,0),(1,24,0,0,0),(2,1,1,0,0),(2,2,1,1,1),(2,3,1,0,0),(2,4,1,0,0),(2,5,1,0,0),(2,6,1,0,0),(2,7,1,0,0),(2,8,1,0,0),(2,9,1,1,1),(2,10,1,0,0),(2,11,1,0,0),(2,12,1,0,0),(2,13,1,0,0),(2,15,1,0,0),(2,17,1,0,0),(2,19,1,0,0),(2,20,1,0,0),(2,21,1,0,0),(2,22,1,0,0),(2,23,1,0,0),(2,24,1,0,0),(3,1,0,0,0),(3,2,0,0,1),(3,3,0,0,0),(3,4,0,0,0),(3,8,0,0,0),(3,9,0,1,1),(4,6,0,1,0),(4,9,0,1,1),(4,14,0,0,0),(7,9,0,1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id_user` int(32) NOT NULL AUTO_INCREMENT,
  `username` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `id_identify` int(32) DEFAULT NULL,
  `id_class` int(32) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id_user`,`username`,`password`,`id_identify`,`id_class`) values (1,'hjc','123',0,1),(2,'hjc','123',1,1),(3,'admin','123',0,1),(4,'student','123',0,1),(7,'ssd','123',0,1),(9,'test','123',0,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
