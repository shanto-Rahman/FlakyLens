@Test(timeout=60000) public void testWrite() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
WRITE3Response response1=nfsd.write(xdr_req.asReadOnlyWrap(),null,1,securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
WRITE3Response response2=nfsd.write(xdr_req.asReadOnlyWrap(),null,1,securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect response:",null,response2);
}