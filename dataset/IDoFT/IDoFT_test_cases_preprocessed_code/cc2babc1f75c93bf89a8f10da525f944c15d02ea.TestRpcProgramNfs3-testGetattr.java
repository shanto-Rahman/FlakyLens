@Test(timeout=60000) public void testGetattr() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
GETATTR3Response response1=nfsd.getattr(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
GETATTR3Response response2=nfsd.getattr(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3_OK,response2.getStatus());
}