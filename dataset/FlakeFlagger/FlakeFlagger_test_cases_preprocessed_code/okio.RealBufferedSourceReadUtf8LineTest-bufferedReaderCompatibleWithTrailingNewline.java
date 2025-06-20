@Test public void bufferedReaderCompatibleWithTrailingNewline() throws IOException {
assertEquals("abc",source.readUtf8Line(false));
assertEquals("def",source.readUtf8Line(false));
assertEquals(null,source.readUtf8Line(false));
}