@Test public void decimal() throws IOException {
assertEquals("var d = 1.34;",template.apply(1.34));
}