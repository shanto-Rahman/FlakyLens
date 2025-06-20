@Test public void testRunWithPermissionsExceptionContent() throws Exception {
  setFileSystemBasicTree(proc.fileSystem);
  proc.fileSystem.addFileStatus(proc.fileSystem.newDir("/some/home/mydir/dir1"),proc.fileSystem.newDir("/some/home/mydir/dir1/list_exception_java.io.InterruptedIOException"));
  runner.setIncomingConnection(false);
  runner.setProperty(GetHDFSFileInfo.FULL_PATH,"/some/home/mydir");
  runner.setProperty(GetHDFSFileInfo.RECURSE_SUBDIRS,"true");
  runner.setProperty(GetHDFSFileInfo.IGNORE_DOTTED_DIRS,"true");
  runner.setProperty(GetHDFSFileInfo.IGNORE_DOTTED_FILES,"true");
  runner.setProperty(GetHDFSFileInfo.DESTINATION,GetHDFSFileInfo.DESTINATION_CONTENT);
  runner.setProperty(GetHDFSFileInfo.GROUPING,GetHDFSFileInfo.GROUP_ALL);
  runner.run();
  runner.assertTransferCount(GetHDFSFileInfo.REL_ORIGINAL,0);
  runner.assertTransferCount(GetHDFSFileInfo.REL_SUCCESS,1);
  runner.assertTransferCount(GetHDFSFileInfo.REL_FAILURE,0);
  runner.assertTransferCount(GetHDFSFileInfo.REL_NOT_FOUND,0);
  final MockFlowFile mff=runner.getFlowFilesForRelationship(GetHDFSFileInfo.REL_SUCCESS).get(0);
  mff.assertContentEquals(Paths.get("src/test/resources/TestGetHDFSFileInfo/testRunWithPermissionsExceptionContent.json"));
}
