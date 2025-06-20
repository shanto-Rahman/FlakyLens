@Test public void smoke(){
File file=new File(filename);//RO
assertTrue(file.exists());
assertTrue("failed to delete " + file.getAbsolutePath(),file.delete());
}