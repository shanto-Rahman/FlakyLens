/** 
 * Ensure that GETXATTRS, SETXATTR, REMOVEXATTR fail.
 */
@Test @TestDir @TestJetty @TestHdfs public void testWithXAttrs() throws Exception {
  final String name1="user.a1";
  final byte[] value1=new byte[]{0x31,0x32,0x33};
  final String dir="/noXAttr";
  final String path=dir + "/file";
  startMiniDFS();
  createHttpFSServer();
  FileSystem fs=FileSystem.get(nnConf);
  fs.mkdirs(new Path(dir));
  OutputStream os=fs.create(new Path(path));
  os.write(1);
  os.close();
  getStatus(path,"GETXATTRS");
  putCmd(path,"SETXATTR",TestHttpFSServer.setXAttrParam(name1,value1));
  putCmd(path,"REMOVEXATTR","xattr.name=" + name1);
}
