/** 
 * Test ACL operations on a directory, including default ACLs. General strategy is to use GETFILESTATUS and GETACLSTATUS to verify: <ol> <li>Initial status with no ACLs</li> <li>The addition of a default ACL</li> <li>The removal of default ACLs</li> </ol>
 * @throws Exception
 */
@Test @TestDir @TestJetty @TestHdfs public void testDirAcls() throws Exception {
  final String defUser1="default:user:glarch:r-x";
  final String defSpec1="aclspec=" + defUser1;
  final String dir="/aclDirTest";
  String statusJson;
  List<String> aclEntries;
  createHttpFSServer(false,false);
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path(dir));
  statusJson=getStatus(dir,"GETFILESTATUS");
  Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(dir,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 0);
  putCmd(dir,"SETACL",defSpec1);
  statusJson=getStatus(dir,"GETFILESTATUS");
  Assert.assertNotEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(dir,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 5);
  Assert.assertTrue(aclEntries.contains(defUser1));
  putCmd(dir,"REMOVEDEFAULTACL",null);
  statusJson=getStatus(dir,"GETFILESTATUS");
  Assert.assertEquals(-1,statusJson.indexOf("aclBit"));
  statusJson=getStatus(dir,"GETACLSTATUS");
  aclEntries=getAclEntries(statusJson);
  Assert.assertTrue(aclEntries.size() == 0);
}
