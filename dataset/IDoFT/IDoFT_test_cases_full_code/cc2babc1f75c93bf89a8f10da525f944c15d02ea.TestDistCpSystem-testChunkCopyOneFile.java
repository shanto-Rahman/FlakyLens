@Test public void testChunkCopyOneFile() throws Exception {
  FileEntry[] srcFiles={new FileEntry(SRCDAT,true),new FileEntry(SRCDAT + "/file0",false)};
  chunkCopy(srcFiles);
}
