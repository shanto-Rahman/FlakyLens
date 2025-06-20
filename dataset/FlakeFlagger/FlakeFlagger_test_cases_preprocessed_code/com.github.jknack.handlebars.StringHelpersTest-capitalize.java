@Test public void capitalize() throws IOException {
assertEquals("capitalize",capitalize.name());
assertEquals("Handlebars Java",capitalize.apply("handlebars java",options));
assertEquals("Handlebars Java",capitalize.apply("HAndleBars JAVA",options));
}