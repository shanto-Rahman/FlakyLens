@Test public void ch() throws IOException {
assertEquals("var s = 'c';",template.apply('c'));
}