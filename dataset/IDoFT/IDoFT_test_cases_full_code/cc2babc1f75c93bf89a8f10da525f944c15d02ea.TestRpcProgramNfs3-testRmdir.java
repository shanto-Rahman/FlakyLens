@Test(timeout=60000) public void testRmdir() throws Exception {
  HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);
  long dirId=status.getFileId();
  int namenodeId=Nfs3Utils.getNamenodeId(config);
  XDR xdr_req=new XDR();
  FileHandle handle=new FileHandle(dirId,namenodeId);
  RMDIR3Request req=new RMDIR3Request(handle,"foo");
  req.serialize(xdr_req);
  RMDIR3Response response1=nfsd.rmdir(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
  RMDIR3Response response2=nfsd.rmdir(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}
