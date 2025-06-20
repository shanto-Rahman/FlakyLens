@Test(timeout=60000) public void testFsstat() throws Exception {
  HdfsFileStatus status=nn.getRpcServer().getFileInfo("/tmp/bar");
  long dirId=status.getFileId();
  int namenodeId=Nfs3Utils.getNamenodeId(config);
  FileHandle handle=new FileHandle(dirId,namenodeId);
  XDR xdr_req=new XDR();
  FSSTAT3Request req=new FSSTAT3Request(handle);
  req.serialize(xdr_req);
  FSSTAT3Response response1=nfsd.fsstat(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
  FSSTAT3Response response2=nfsd.fsstat(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}
