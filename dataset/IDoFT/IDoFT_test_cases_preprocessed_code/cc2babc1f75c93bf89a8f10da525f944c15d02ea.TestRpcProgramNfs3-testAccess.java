@Test(timeout=60000) public void testAccess() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
ACCESS3Response response1=nfsd.access(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
ACCESS3Response response2=nfsd.access(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3_OK,response2.getStatus());
}