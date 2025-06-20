@Test(timeout=60000) public void testReadlink() throws Exception {
HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);//RW
int namenodeId=Nfs3Utils.getNamenodeId(config);//RW
SYMLINK3Response response=nfsd.symlink(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response.getStatus());
READLINK3Response response1=nfsd.readlink(xdr_req2.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
READLINK3Response response2=nfsd.readlink(xdr_req2.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));//RW
assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}