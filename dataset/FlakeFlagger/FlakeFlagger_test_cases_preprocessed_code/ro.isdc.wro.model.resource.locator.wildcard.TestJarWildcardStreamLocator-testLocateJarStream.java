@Test public void testLocateJarStream() throws IOException {
final InputStream is=jarStreamLocator.locateStream("com/test/app/*.js",new File(jarFileName));//RO
assertEquals(testInfo,lines.get(0));
}