@Test public void testPreserveUseNonEmptyDir() throws Exception {
  String testRoot="/testdir." + getMethodName();
  FileEntry[] srcfiles={new FileEntry(SRCDAT,true),new FileEntry(SRCDAT + "/a",false),new FileEntry(SRCDAT + "/b",true),new FileEntry(SRCDAT + "/b/c",false)};
  FileEntry[] dstfiles={new FileEntry(DSTDAT,true),new FileEntry(DSTDAT + "/a",false),new FileEntry(DSTDAT + "/b",true),new FileEntry(DSTDAT + "/b/c",false)};
  testPreserveUserHelper(testRoot,srcfiles,srcfiles,false,true,false);
  testPreserveUserHelper(testRoot,srcfiles,dstfiles,false,false,false);
}
