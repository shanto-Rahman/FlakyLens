@Test public void stringFormat() throws IOException {
assertEquals("stringFormat",stringFormat.name());
assertEquals("Hello handlebars.java!",stringFormat.apply("Hello %s!",options));
}