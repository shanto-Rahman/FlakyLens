@Test public void inheritance() throws IOException {
String expected=FileUtils.readFileToString(new File("src/test/resources/inheritance/" + name + ".expected"));//RO
assertEquals(expected,result);
}