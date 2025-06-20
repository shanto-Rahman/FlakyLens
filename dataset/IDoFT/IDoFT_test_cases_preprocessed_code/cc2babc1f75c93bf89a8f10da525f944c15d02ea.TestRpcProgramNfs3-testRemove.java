@Test(timeout=60000) public void testRemove() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
REMOVE3Response response1=nfsd.remove(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
REMOVE3Response response2=nfsd.remove(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}