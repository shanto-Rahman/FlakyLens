@Test public void dontEscape() throws IOException {
assertEquals("var s = '<div>';",template.apply("<div>"));
}