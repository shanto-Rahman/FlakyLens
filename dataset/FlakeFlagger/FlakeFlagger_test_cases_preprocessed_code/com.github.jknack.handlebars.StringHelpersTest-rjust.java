@Test public void rjust() throws IOException {
assertEquals("rjust",rjust.name());
assertEquals("     Handlebars.java",rjust.apply("Handlebars.java",options));
}