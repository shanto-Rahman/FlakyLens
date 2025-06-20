@Test public void skipTracksBufferFirst() throws Exception {
assertEquals(0,bufferedSource.buffer().size());
assertEquals(2,source.size());
}