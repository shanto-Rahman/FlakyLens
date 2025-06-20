@Test(timeout=60000) public void testNfsRenameSingleNN() throws Exception {
HdfsFileStatus fromFileStatus=nn1.getRpcServer().getFileInfo("/user1");//RW
int fromNNId=Nfs3Utils.getNamenodeId(config,hdfs1.getUri());//RW
HdfsFileStatus statusBeforeRename=nn1.getRpcServer().getFileInfo("/user1/renameSingleNN");//RW
Assert.assertEquals(statusBeforeRename.isDirectory(),false);
HdfsFileStatus statusAfterRename=nn1.getRpcServer().getFileInfo("/user1/renameSingleNNSucess");//RW
Assert.assertEquals(statusAfterRename.isDirectory(),false);
statusAfterRename=nn1.getRpcServer().getFileInfo("/user1/renameSingleNN");//RW
Assert.assertEquals(statusAfterRename,null);
}