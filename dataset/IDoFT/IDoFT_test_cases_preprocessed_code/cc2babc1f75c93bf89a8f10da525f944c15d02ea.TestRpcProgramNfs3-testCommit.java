@Test(timeout=60000) public void testCommit() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
COMMIT3Response response1=nfsd.commit(xdr_req.asReadOnlyWrap(),ch,1,securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
COMMIT3Response response2=nfsd.commit(xdr_req.asReadOnlyWrap(),ch,1,securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect COMMIT3Response:",null,response2);
}