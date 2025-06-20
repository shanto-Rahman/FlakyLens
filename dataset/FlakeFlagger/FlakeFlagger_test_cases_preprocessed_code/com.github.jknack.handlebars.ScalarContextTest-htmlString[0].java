@Test public void htmlString() throws IOException {
assertEquals("var s = '&lt;div&gt;';",template.apply("<div>"));
}