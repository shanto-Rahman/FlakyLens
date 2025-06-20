@Test(timeout=60000) public void testSymlink() throws Exception {
  HdfsFileStatus status=nn.getRpcServer().getFileInfo(testdir);
  long dirId=status.getFileId();
  int namenodeId=Nfs3Utils.getNamenodeId(config);
  XDR xdr_req=new XDR();
  FileHandle handle=new FileHandle(dirId,namenodeId);
  SYMLINK3Request req=new SYMLINK3Request(handle,"fubar",new SetAttr3(),"bar");
  req.serialize(xdr_req);
  SYMLINK3Response response1=nfsd.symlink(xdr_req.asReadOnlyWrap(),securityHandlerUnpriviledged,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3ERR_ACCES,response1.getStatus());
  SYMLINK3Response response2=nfsd.symlink(xdr_req.asReadOnlyWrap(),securityHandler,new InetSocketAddress("localhost",1234));
  assertEquals("Incorrect return code:",Nfs3Status.NFS3_OK,response2.getStatus());
}
