@Test(expected=IOException.class) public void cannotProcessUriWithoutWildcard() throws IOException {
final File folder=new File(ClassLoader.getSystemResource("").getFile());//RO
}