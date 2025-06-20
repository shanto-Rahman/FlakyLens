@Test(timeout=60000) public void testNfsRenameSingleNN() throws Exception {
DFSTestUtil.createFile(viewFs,new Path("/hdfs1/renameSingleNN"),0,(short)1,0);//RW
HdfsFileStatus fromFileStatus=nn1.getRpcServer().getFileInfo("/user1");//RW
int fromNNId=Nfs3Utils.getNamenodeId(config,hdfs1.getUri());//RW
HdfsFileStatus statusBeforeRename=nn1.getRpcServer().getFileInfo("/user1/renameSingleNN");//RW
Assert.assertEquals(statusBeforeRename.isDirectory(),false);
hdfs1.delete(successFilePath,false);//RW
HdfsFileStatus statusAfterRename=nn1.getRpcServer().getFileInfo("/user1/renameSingleNNSucess");//RW
Assert.assertEquals(statusAfterRename.isDirectory(),false);
statusAfterRename=nn1.getRpcServer().getFileInfo("/user1/renameSingleNN");//RW
Assert.assertEquals(statusAfterRename,null);
}