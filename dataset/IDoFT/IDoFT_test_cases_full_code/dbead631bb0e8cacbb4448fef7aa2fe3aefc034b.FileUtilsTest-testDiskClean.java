@Test public void testDiskClean(){
  File dc=new File(resourceFolder,"diskclean");
  assertTrue(dc.exists());
  FileUtils.renameDoneFile(new File(dc,"filestodelete.txt"));
  File[] files=FileUtils.loadDoneFiles(dc);
  assertTrue(files.length > 0);
  FileUtils.diskClean(dc,0);
  files=FileUtils.loadDoneFiles(dc);
  assertEquals(0,files.length);
}
