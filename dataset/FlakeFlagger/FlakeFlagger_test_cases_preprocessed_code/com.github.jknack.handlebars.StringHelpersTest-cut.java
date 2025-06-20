@Test public void cut() throws IOException {
assertEquals("cut",cut.name());
assertEquals("handlebars.java",cut.apply("handle bars .  java",options));
}