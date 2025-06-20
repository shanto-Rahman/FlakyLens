@Test(timeout=60000) public void testNfsAccessNN2() throws Exception {
HdfsFileStatus status=nn2.getRpcServer().getFileInfo("/user2/dir2");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config,hdfs2.getUri());//RW
}