@Test(timeout=60000) public void testGetattr() throws Exception {
  HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");
  long dirId=status.getFileId();
  int namenodeId=Nfs3Utils.getNamenodeId(config);
  FileHandle handle=new FileHandle(dirId,namenodeId);
  XDR xdr_req=new XDR();
  GETATTR3Request req=new GETATTR3Request(handle);
  req.serialize(xdr_req);
  GETATTR3Response response1=nfsd.getattr(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
  GETATTR3Response response2=nfsd.getattr(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code",Nfs3Status.NFS3_OK,response2.getStatus());
}
