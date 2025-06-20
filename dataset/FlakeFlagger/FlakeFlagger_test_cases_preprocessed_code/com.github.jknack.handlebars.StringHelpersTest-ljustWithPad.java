@Test public void ljustWithPad() throws IOException {
assertEquals("ljust",ljust.name());
assertEquals("Handlebars.java++",ljust.apply("Handlebars.java",options));
}