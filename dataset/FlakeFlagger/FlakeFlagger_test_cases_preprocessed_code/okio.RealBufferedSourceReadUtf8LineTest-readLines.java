@Test public void readLines() throws IOException {
assertEquals("abc",source.readUtf8Line(true));
assertEquals("def",source.readUtf8Line(true));
fail();
}