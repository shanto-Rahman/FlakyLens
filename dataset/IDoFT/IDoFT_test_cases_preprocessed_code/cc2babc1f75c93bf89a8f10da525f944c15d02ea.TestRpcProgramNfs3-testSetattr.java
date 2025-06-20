@Test(timeout=60000) public void testSetattr() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
SETATTR3Response response1=nfsd.setattr(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
SETATTR3Response response2=nfsd.setattr(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3_OK,response2.getStatus());
}