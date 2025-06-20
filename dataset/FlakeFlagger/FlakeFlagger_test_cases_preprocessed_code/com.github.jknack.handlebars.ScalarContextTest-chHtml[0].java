@Test public void chHtml() throws IOException {
assertEquals("var s = '&lt;';",template.apply('<'));
}