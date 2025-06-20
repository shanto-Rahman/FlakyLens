@Test public void ljust() throws IOException {
assertEquals("ljust",ljust.name());
assertEquals("Handlebars.java     ",ljust.apply("Handlebars.java",options));
}