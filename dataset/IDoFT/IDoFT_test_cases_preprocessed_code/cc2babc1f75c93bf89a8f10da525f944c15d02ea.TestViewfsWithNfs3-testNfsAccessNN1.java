@Test(timeout=60000) public void testNfsAccessNN1() throws Exception {
HdfsFileStatus status=nn1.getRpcServer().getFileInfo("/user1/file1");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config,hdfs1.getUri());//RW
}