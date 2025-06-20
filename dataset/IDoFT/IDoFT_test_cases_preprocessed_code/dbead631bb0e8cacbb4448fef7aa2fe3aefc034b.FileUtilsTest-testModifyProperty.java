@Test public void testModifyProperty(){
File file=new File(resourceFolder,"application.properties");
assertFalse(unmodified.equals(modified));
}