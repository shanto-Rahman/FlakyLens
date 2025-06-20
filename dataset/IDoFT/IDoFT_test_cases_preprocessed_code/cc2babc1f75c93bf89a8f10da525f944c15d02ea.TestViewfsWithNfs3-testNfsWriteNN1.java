@Test(timeout=60000) public void testNfsWriteNN1() throws Exception {
HdfsFileStatus status=nn1.getRpcServer().getFileInfo("/user1/write1");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config,hdfs1.getUri());//RW
}