@Test public void useMissingValue() throws IOException {
assertEquals(hash,context);
assertEquals("missingVar",var);
assertEquals("(none)",handlebars.compile("{{missingVar}}").apply(hash));
}