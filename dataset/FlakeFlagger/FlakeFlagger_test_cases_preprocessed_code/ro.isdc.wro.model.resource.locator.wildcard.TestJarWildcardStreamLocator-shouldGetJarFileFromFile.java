@Test public void shouldGetJarFileFromFile(){
final String actual=jarStreamLocator.getJarFile(new File("file:path/to/file!one/two/three.class")).getPath();//RO
Assert.assertEquals(expected,actual);
}