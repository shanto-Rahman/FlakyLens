@Test public void string() throws IOException {
assertEquals("var s = 'Hello';",template.apply("Hello"));
}