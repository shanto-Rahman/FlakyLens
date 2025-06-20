@Test(expected=IOException.class) public void testWithInvalidFolder() throws IOException {
final File folder=new File(ClassLoader.getSystemResource("1.css").getFile());//RO
}