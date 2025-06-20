@Test public void crDroppedPrecedingLf() throws IOException {
assertEquals("abc",source.readUtf8Line(true));
assertEquals("def",source.readUtf8Line(true));
assertEquals("ghi\rjkl",source.readUtf8Line(true));
}