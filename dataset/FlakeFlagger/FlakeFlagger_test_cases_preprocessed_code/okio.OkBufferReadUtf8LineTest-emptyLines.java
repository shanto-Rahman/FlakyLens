@Test public void emptyLines() throws IOException {
assertEquals("",source.readUtf8Line(true));
assertEquals("",source.readUtf8Line(true));
assertEquals("",source.readUtf8Line(true));
assertTrue(source.exhausted());
}