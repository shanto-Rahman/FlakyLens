/** 
 * Validate XAttr get/set/remove calls.
 */
@Test @TestDir @TestJetty @TestHdfs public void testXAttrs() throws Exception {
  final String name1="user.a1";
  final byte[] value1=new byte[]{0x31,0x32,0x33};
  final String name2="user.a2";
  final byte[] value2=new byte[]{0x41,0x42,0x43};
  final String dir="/xattrTest";
  final String path=dir + "/file";
  createHttpFSServer(false,false);
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path(dir));
  createWithHttp(path,null);
  String statusJson=getStatus(path,"GETXATTRS");
  Map<String,byte[]> xAttrs=getXAttrs(statusJson);
  Assert.assertEquals(0,xAttrs.size());
  putCmd(path,"SETXATTR",setXAttrParam(name1,value1));
  putCmd(path,"SETXATTR",setXAttrParam(name2,value2));
  statusJson=getStatus(path,"GETXATTRS");
  xAttrs=getXAttrs(statusJson);
  Assert.assertEquals(2,xAttrs.size());
  Assert.assertArrayEquals(value1,xAttrs.get(name1));
  Assert.assertArrayEquals(value2,xAttrs.get(name2));
  putCmd(path,"REMOVEXATTR","xattr.name=" + name1);
  statusJson=getStatus(path,"GETXATTRS");
  xAttrs=getXAttrs(statusJson);
  Assert.assertEquals(1,xAttrs.size());
  Assert.assertArrayEquals(value2,xAttrs.get(name2));
  putCmd(path,"REMOVEXATTR","xattr.name=" + name2);
  statusJson=getStatus(path,"GETXATTRS");
  xAttrs=getXAttrs(statusJson);
  Assert.assertEquals(0,xAttrs.size());
}
