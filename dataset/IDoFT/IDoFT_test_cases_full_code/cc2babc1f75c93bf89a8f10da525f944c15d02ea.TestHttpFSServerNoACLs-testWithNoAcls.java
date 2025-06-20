/** 
 * Test without ACLs. Ensure that <ol> <li>GETFILESTATUS and LISTSTATUS work happily</li> <li>ACLSTATUS throws an exception</li> <li>The ACL SET, REMOVE, etc calls all fail</li> </ol>
 * @throws Exception
 */
@Test @TestDir @TestJetty public void testWithNoAcls() throws Exception {
  final String aclUser1="user:foo:rw-";
  final String rmAclUser1="user:foo:";
  final String aclUser2="user:bar:r--";
  final String aclGroup1="group::r--";
  final String aclSpec="aclspec=user::rwx," + aclUser1 + ","+ aclGroup1+ ",other::---";
  final String modAclSpec="aclspec=" + aclUser2;
  final String remAclSpec="aclspec=" + rmAclUser1;
  final String defUser1="default:user:glarch:r-x";
  final String defSpec1="aclspec=" + defUser1;
  final String dir="/noACLs";
  final String path=dir + "/foo";
  startMiniDFS();
  createHttpFSServer();
  FileSystem fs=FileSystem.get(nnConf);
  fs.mkdirs(new Path(dir));
  OutputStream os=fs.create(new Path(path));
  os.write(1);
  os.close();
  getStatus(path,"GETFILESTATUS",true);
  getStatus(dir,"LISTSTATUS",true);
  getStatus(path,"GETACLSTATUS",false);
  putCmd(path,"SETACL",aclSpec,false);
  putCmd(path,"MODIFYACLENTRIES",modAclSpec,false);
  putCmd(path,"REMOVEACLENTRIES",remAclSpec,false);
  putCmd(path,"REMOVEACL",null,false);
  putCmd(dir,"SETACL",defSpec1,false);
  putCmd(dir,"REMOVEDEFAULTACL",null,false);
  miniDfs.shutdown();
}
