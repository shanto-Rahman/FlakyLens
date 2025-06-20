@Test public void testFromFolder() throws IOException {
final File testFolder=new File(ClassLoader.getSystemResource("test").getFile());//RO
final File expectedFolder=new File(url.getFile(),"expected");
}