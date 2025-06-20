@Test public void testPreserveUserSingleFile() throws Exception {
  String testRoot="/testdir." + getMethodName();
  FileEntry[] srcfiles={new FileEntry(SRCDAT,false)};
  FileEntry[] dstfiles={new FileEntry(DSTDAT,false)};
  testPreserveUserHelper(testRoot,srcfiles,srcfiles,false,true,false);
  testPreserveUserHelper(testRoot,srcfiles,dstfiles,false,false,false);
}
