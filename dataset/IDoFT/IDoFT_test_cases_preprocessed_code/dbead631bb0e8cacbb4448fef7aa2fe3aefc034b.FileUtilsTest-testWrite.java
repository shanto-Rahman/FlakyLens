@Test public void testWrite(){
File dc=new File(resourceFolder,"diskclean");
File file=new File(dc,"test.done");
assertFalse(file.exists());
assertTrue(file.exists());
}