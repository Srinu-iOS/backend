--
-- Dumping data for table `user admin`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user`(user_id,name,password,status,user_type,email_id) VALUES (1,'Admin','admin123',true,1,'admin@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
