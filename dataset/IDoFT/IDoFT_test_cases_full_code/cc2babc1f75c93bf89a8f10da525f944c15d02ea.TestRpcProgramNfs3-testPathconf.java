@Test(timeout=60000) public void testPathconf() throws Exception {
  HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");
  long dirId=status.getFileId();
  int namenodeId=Nfs3Utils.getNamenodeId(config);
  FileHandle handle=new FileHandle(dirId,namenodeId);
  XDR xdr_req=new XDR();
  PATHCONF3Request req=new PATHCONF3Request(handle);
  req.serialize(xdr_req);
  PATHCONF3Response response1=nfsd.pathconf(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
  PATHCONF3Response response2=nfsd.pathconf(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}
