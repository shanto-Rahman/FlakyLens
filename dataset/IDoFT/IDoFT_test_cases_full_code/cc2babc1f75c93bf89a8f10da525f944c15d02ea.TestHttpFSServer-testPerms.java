/** 
 * Validate that files are created with 755 permissions when no 'permissions' attribute is specified, and when 'permissions' is specified, that value is honored.
 */
@Test @TestDir @TestJetty @TestHdfs public void testPerms() throws Exception {
  createHttpFSServer(false,false);
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path("/perm"));
  createWithHttp("/perm/none",null);
  String statusJson=getStatus("/perm/none","GETFILESTATUS");
  Assert.assertTrue("755".equals(getPerms(statusJson)));
  createWithHttp("/perm/p-777","777");
  statusJson=getStatus("/perm/p-777","GETFILESTATUS");
  Assert.assertTrue("777".equals(getPerms(statusJson)));
  createWithHttp("/perm/p-654","654");
  statusJson=getStatus("/perm/p-654","GETFILESTATUS");
  Assert.assertTrue("654".equals(getPerms(statusJson)));
  createWithHttp("/perm/p-321","321");
  statusJson=getStatus("/perm/p-321","GETFILESTATUS");
  Assert.assertTrue("321".equals(getPerms(statusJson)));
}
