@Test public void integer() throws IOException {
assertEquals("var i = 10;",template.apply(10));
}