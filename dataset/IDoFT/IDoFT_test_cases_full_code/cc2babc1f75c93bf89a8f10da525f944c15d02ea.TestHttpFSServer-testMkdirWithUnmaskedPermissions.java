@Test @TestDir @TestJetty @TestHdfs public void testMkdirWithUnmaskedPermissions() throws Exception {
  createHttpFSServer(false,false);
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path("/tmp"));
  AclEntry acl=new org.apache.hadoop.fs.permission.AclEntry.Builder().setType(AclEntryType.USER).setScope(AclEntryScope.DEFAULT).setName("user2").setPermission(FsAction.READ_WRITE).build();
  fs.setAcl(new Path("/tmp"),new ArrayList<AclEntry>(Arrays.asList(acl)));
  String notUnmaskedDir="/tmp/notUnmaskedDir";
  String unmaskedDir="/tmp/unmaskedDir";
  createDirWithHttp(notUnmaskedDir,"700",null);
  AclStatus aclStatus=fs.getAclStatus(new Path(notUnmaskedDir));
  AclEntry theAcl=findAclWithName(aclStatus,"user2");
  Assert.assertNotNull(theAcl);
  Assert.assertEquals(FsAction.NONE,aclStatus.getEffectivePermission(theAcl));
  createDirWithHttp(unmaskedDir,"700","777");
  aclStatus=fs.getAclStatus(new Path(unmaskedDir));
  theAcl=findAclWithName(aclStatus,"user2");
  Assert.assertNotNull(theAcl);
  Assert.assertEquals(FsAction.READ_WRITE,aclStatus.getEffectivePermission(theAcl));
}
