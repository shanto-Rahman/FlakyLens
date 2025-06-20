@Test public void test_windowAbsolutePathBeginWithSlashIsValid() throws Exception {
if (!osProperty.toLowerCase().contains("windows")) return;
File f0=new File("C:/Windows");//RO
File f1=new File("/C:/Windows");//RO
File f2=new File("C:\\Windows");//RO
File f3=new File("/C:\\Windows");//RO
File f4=new File("\\C:\\Windows");//RO
assertEquals(f0,f1);
assertEquals(f0,f2);
assertEquals(f0,f3);
assertEquals(f0,f4);
}