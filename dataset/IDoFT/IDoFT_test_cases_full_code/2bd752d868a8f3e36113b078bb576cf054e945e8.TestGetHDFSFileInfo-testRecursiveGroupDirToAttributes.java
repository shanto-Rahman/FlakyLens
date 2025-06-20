@Test public void testRecursiveGroupDirToAttributes() throws Exception {
  setFileSystemBasicTree(proc.fileSystem);
  runner.setIncomingConnection(false);
  runner.setProperty(GetHDFSFileInfo.FULL_PATH,"/some/home/mydir");
  runner.setProperty(GetHDFSFileInfo.RECURSE_SUBDIRS,"true");
  runner.setProperty(GetHDFSFileInfo.IGNORE_DOTTED_DIRS,"true");
  runner.setProperty(GetHDFSFileInfo.IGNORE_DOTTED_FILES,"true");
  runner.setProperty(GetHDFSFileInfo.DESTINATION,GetHDFSFileInfo.DESTINATION_ATTRIBUTES);
  runner.setProperty(GetHDFSFileInfo.GROUPING,GetHDFSFileInfo.GROUP_PARENT_DIR);
  runner.run();
  runner.assertTransferCount(GetHDFSFileInfo.REL_ORIGINAL,0);
  runner.assertTransferCount(GetHDFSFileInfo.REL_SUCCESS,5);
  runner.assertTransferCount(GetHDFSFileInfo.REL_FAILURE,0);
  runner.assertTransferCount(GetHDFSFileInfo.REL_NOT_FOUND,0);
  int matchCount=0;
  for (  final MockFlowFile mff : runner.getFlowFilesForRelationship(GetHDFSFileInfo.REL_SUCCESS)) {
    if (mff.getAttribute("hdfs.objectName").equals("mydir")) {
      matchCount++;
      mff.assertAttributeEquals("hdfs.path","/some/home");
      mff.assertAttributeEquals("hdfs.type","directory");
      mff.assertAttributeEquals("hdfs.owner","owner");
      mff.assertAttributeEquals("hdfs.group","group");
      mff.assertAttributeEquals("hdfs.lastModified","" + 1523456000000L);
      mff.assertAttributeEquals("hdfs.length","" + 900);
      mff.assertAttributeEquals("hdfs.count.files","" + 9);
      mff.assertAttributeEquals("hdfs.count.dirs","" + 10);
      mff.assertAttributeEquals("hdfs.replication","" + 3);
      mff.assertAttributeEquals("hdfs.permissions","rwxr-xr-x");
      mff.assertAttributeNotExists("hdfs.status");
      final String expected=new String(Files.readAllBytes(Paths.get("src/test/resources/TestGetHDFSFileInfo/testRecursiveGroupDirToAttributes-mydir.json")));
      mff.assertAttributeEquals("hdfs.full.tree",expected);
    }
 else     if (mff.getAttribute("hdfs.objectName").equals("dir1")) {
      matchCount++;
      mff.assertAttributeEquals("hdfs.path","/some/home/mydir");
      mff.assertAttributeEquals("hdfs.type","directory");
      mff.assertAttributeEquals("hdfs.owner","owner");
      mff.assertAttributeEquals("hdfs.group","group");
      mff.assertAttributeEquals("hdfs.lastModified","" + 1523456000000L);
      mff.assertAttributeEquals("hdfs.length","" + 200);
      mff.assertAttributeEquals("hdfs.count.files","" + 2);
      mff.assertAttributeEquals("hdfs.count.dirs","" + 3);
      mff.assertAttributeEquals("hdfs.replication","" + 3);
      mff.assertAttributeEquals("hdfs.permissions","rwxr-xr-x");
      mff.assertAttributeNotExists("hdfs.status");
      final String expected=new String(Files.readAllBytes(Paths.get("src/test/resources/TestGetHDFSFileInfo/testRecursiveGroupDirToAttributes-dir1.json")));
      mff.assertAttributeEquals("hdfs.full.tree",expected);
    }
 else     if (mff.getAttribute("hdfs.objectName").equals("dir2")) {
      matchCount++;
      mff.assertAttributeEquals("hdfs.path","/some/home/mydir");
      mff.assertAttributeEquals("hdfs.type","directory");
      mff.assertAttributeEquals("hdfs.owner","owner");
      mff.assertAttributeEquals("hdfs.group","group");
      mff.assertAttributeEquals("hdfs.lastModified","" + 1523456000000L);
      mff.assertAttributeEquals("hdfs.length","" + 200);
      mff.assertAttributeEquals("hdfs.count.files","" + 2);
      mff.assertAttributeEquals("hdfs.count.dirs","" + 3);
      mff.assertAttributeEquals("hdfs.replication","" + 3);
      mff.assertAttributeEquals("hdfs.permissions","rwxr-xr-x");
      mff.assertAttributeNotExists("hdfs.status");
      final String expected=new String(Files.readAllBytes(Paths.get("src/test/resources/TestGetHDFSFileInfo/testRecursiveGroupDirToAttributes-dir2.json")));
      mff.assertAttributeEquals("hdfs.full.tree",expected);
    }
 else     if (mff.getAttribute("hdfs.objectName").equals("regDir")) {
      matchCount++;
      mff.assertAttributeEquals("hdfs.path","/some/home/mydir/dir1");
      mff.assertAttributeEquals("hdfs.type","directory");
      mff.assertAttributeEquals("hdfs.owner","owner");
      mff.assertAttributeEquals("hdfs.group","group");
      mff.assertAttributeEquals("hdfs.lastModified","" + 1523456000000L);
      mff.assertAttributeEquals("hdfs.length","" + 0);
      mff.assertAttributeEquals("hdfs.count.files","" + 0);
      mff.assertAttributeEquals("hdfs.count.dirs","" + 1);
      mff.assertAttributeEquals("hdfs.replication","" + 3);
      mff.assertAttributeEquals("hdfs.permissions","rwxr-xr-x");
      mff.assertAttributeNotExists("hdfs.status");
      final String expected=new String(Files.readAllBytes(Paths.get("src/test/resources/TestGetHDFSFileInfo/testRecursiveGroupDirToAttributes-regDir.json")));
      mff.assertAttributeEquals("hdfs.full.tree",expected);
    }
 else     if (mff.getAttribute("hdfs.objectName").equals("regDir2")) {
      matchCount++;
      mff.assertAttributeEquals("hdfs.path","/some/home/mydir/dir2");
      mff.assertAttributeEquals("hdfs.type","directory");
      mff.assertAttributeEquals("hdfs.owner","owner");
      mff.assertAttributeEquals("hdfs.group","group");
      mff.assertAttributeEquals("hdfs.lastModified","" + 1523456000000L);
      mff.assertAttributeEquals("hdfs.length","" + 0);
      mff.assertAttributeEquals("hdfs.count.files","" + 0);
      mff.assertAttributeEquals("hdfs.count.dirs","" + 1);
      mff.assertAttributeEquals("hdfs.replication","" + 3);
      mff.assertAttributeEquals("hdfs.permissions","rwxr-xr-x");
      mff.assertAttributeNotExists("hdfs.status");
      final String expected=new String(Files.readAllBytes(Paths.get("src/test/resources/TestGetHDFSFileInfo/testRecursiveGroupDirToAttributes-regDir2.json")));
      mff.assertAttributeEquals("hdfs.full.tree",expected);
    }
 else {
      runner.assertNotValid();
    }
  }
  Assert.assertEquals(matchCount,5);
}
