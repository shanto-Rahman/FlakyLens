@Test public void testDiskClean(){
File dc=new File(resourceFolder,"diskclean");
assertTrue(dc.exists());
FileUtils.renameDoneFile(new File(dc,"filestodelete.txt"));
assertTrue(files.length > 0);
assertEquals(0,files.length);
}