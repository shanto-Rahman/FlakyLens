@Test public void cutNoWhitespace() throws IOException {
assertEquals("cut",cut.name());
assertEquals("handlebars.java",cut.apply("handle*bars*.**java",options));
}