@Test public void requireIncludesBufferBytes() throws Exception {
assertEquals("ab",bufferedSource.buffer().readUtf8(2));
}