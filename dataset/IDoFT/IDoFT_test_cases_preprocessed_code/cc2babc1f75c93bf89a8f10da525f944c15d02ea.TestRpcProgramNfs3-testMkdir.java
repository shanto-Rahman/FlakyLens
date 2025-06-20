@Test(timeout=60000) public void testMkdir() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
MKDIR3Response response1=nfsd.mkdir(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
MKDIR3Response response2=nfsd.mkdir(xdr_req2.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}