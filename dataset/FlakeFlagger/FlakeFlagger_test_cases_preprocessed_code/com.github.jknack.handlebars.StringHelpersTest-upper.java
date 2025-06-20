@Test public void upper() throws IOException {
assertEquals("upper",upper.name());
assertEquals("HANDLEBARS.JAVA",upper.apply("Handlebars.java",options));
}