@Test public void center() throws IOException {
assertEquals("center",center.name());
assertEquals("  Handlebars.java  ",center.apply("Handlebars.java",options));
}