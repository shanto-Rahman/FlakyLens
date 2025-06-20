@Test public void requireTracksBufferFirst() throws Exception {
assertEquals(2,bufferedSource.buffer().size());
assertEquals(2,source.size());
}