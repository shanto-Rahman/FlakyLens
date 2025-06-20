@Test public void testRecursiveChunkCopy() throws Exception {
  FileEntry[] srcFiles={new FileEntry(SRCDAT,true),new FileEntry(SRCDAT + "/file0",false),new FileEntry(SRCDAT + "/dir1",true),new FileEntry(SRCDAT + "/dir2",true),new FileEntry(SRCDAT + "/dir1/file1",false)};
  chunkCopy(srcFiles);
}
