@Test public void naturalDay() throws IOException {
assertEquals("yesterday",handlebars.compile("{{naturalDay this locale=\"en_US\"}}").apply(yesterday));
assertEquals("today",handlebars.compile("{{naturalDay this locale=\"en_US\"}}").apply(now));
assertEquals("tomorrow",handlebars.compile("{{naturalDay this locale=\"en_US\"}}").apply(tomorrow));
}