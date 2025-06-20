@Test public void abbreviate() throws IOException {
assertEquals("abbreviate",abbreviate.name());
assertEquals("Handlebars...",abbreviate.apply("Handlebars.java",options));
}