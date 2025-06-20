@Test @TestDir @TestJetty @TestHdfs public void testGetTrashRoot() throws Exception {
  String user=HadoopUsersConfTestHelper.getHadoopUsers()[0];
  createHttpFSServer(false,false);
  String trashJson=getStatus("/","GETTRASHROOT");
  String trashPath=getPath(trashJson);
  Path expectedPath=new Path(FileSystem.USER_HOME_PREFIX,new Path(user,FileSystem.TRASH_PREFIX));
  Assert.assertEquals(expectedPath.toUri().getPath(),trashPath);
  byte[] array=new byte[]{0,1,2,3};
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path("/tmp"));
  OutputStream os=fs.create(new Path("/tmp/foo"));
  os.write(array);
  os.close();
  trashJson=getStatus("/tmp/foo","GETTRASHROOT");
  trashPath=getPath(trashJson);
  Assert.assertEquals(expectedPath.toUri().getPath(),trashPath);
  final Path ezFile=TestHdfsHelper.ENCRYPTED_FILE;
  final Path ezPath=TestHdfsHelper.ENCRYPTION_ZONE;
  trashJson=getStatus(ezFile.toUri().getPath(),"GETTRASHROOT");
  trashPath=getPath(trashJson);
  expectedPath=new Path(ezPath,new Path(FileSystem.TRASH_PREFIX,user));
  Assert.assertEquals(expectedPath.toUri().getPath(),trashPath);
}
