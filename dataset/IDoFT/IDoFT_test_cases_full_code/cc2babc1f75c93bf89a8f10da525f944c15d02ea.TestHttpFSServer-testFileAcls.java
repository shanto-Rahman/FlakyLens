/** 
 * Validate the various ACL set/modify/remove calls.  General strategy is to verify each of the following steps with GETFILESTATUS, LISTSTATUS, and GETACLSTATUS: <ol> <li>Create a file with no ACLs</li> <li>Add a user + group ACL</li> <li>Add another user ACL</li> <li>Remove the first user ACL</li> <li>Remove all ACLs</li> </ol>
 */
@Test @TestDir @TestJetty @TestHdfs public void testFileAcls() throws Exception {
  final String aclUser1="user:foo:rw-";
  final String remAclUser1="user:foo:";
  final String aclUser2="user:bar:r--";
  final String aclGroup1="group::r--";
  final String aclSpec="aclspec=user::rwx," + aclUser1 + ","+ aclGroup1+ ",other::---";
  final String modAclSpec="aclspec=" + aclUser2;
  final String remAclSpec="aclspec=" + remAclUser1;
  final String dir="/aclFileTest";
  final String path=dir + "/test";
  String statusJson;
  List<String> aclEntries;
  createHttpFSServer(false,false);
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path(dir));
  createWithHttp(path,null);
  statusJson=getStatus(path,"GETFILESTATUS");
  Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(dir,"LISTSTATUS");
  Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(path,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 0);
  putCmd(path,"SETACL",aclSpec);
  statusJson=getStatus(path,"GETFILESTATUS");
  Assert.assertNotEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(dir,"LISTSTATUS");
  Assert.assertNotEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(path,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 2);
  Assert.assertTrue(aclEntries.contains(aclUser1));
  Assert.assertTrue(aclEntries.contains(aclGroup1));
  putCmd(path,"MODIFYACLENTRIES",modAclSpec);
  statusJson=getStatus(path,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 3);
  Assert.assertTrue(aclEntries.contains(aclUser1));
  Assert.assertTrue(aclEntries.contains(aclUser2));
  Assert.assertTrue(aclEntries.contains(aclGroup1));
  putCmd(path,"REMOVEACLENTRIES",remAclSpec);
  statusJson=getStatus(path,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 2);
  Assert.assertTrue(aclEntries.contains(aclUser2));
  Assert.assertTrue(aclEntries.contains(aclGroup1));
  putCmd(path,"REMOVEACL",null);
  statusJson=getStatus(path,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 0);
  statusJson=getStatus(path,"GETFILESTATUS");
  Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(dir,"LISTSTATUS");
  Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
}
