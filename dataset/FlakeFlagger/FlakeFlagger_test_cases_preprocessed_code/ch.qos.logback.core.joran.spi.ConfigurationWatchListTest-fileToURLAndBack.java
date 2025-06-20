@Test public void fileToURLAndBack() throws MalformedURLException {
File file=new File("a b.xml");//RO
assertEquals(file.getName(),back.getName());
}