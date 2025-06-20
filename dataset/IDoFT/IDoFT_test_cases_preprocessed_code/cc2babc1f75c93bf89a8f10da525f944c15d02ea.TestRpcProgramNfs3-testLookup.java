@Test(timeout=60000) public void testLookup() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
LOOKUP3Response response1=nfsd.lookup(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
LOOKUP3Response response2=nfsd.lookup(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code",Nfs3Status.NFS3_OK,response2.getStatus());
}