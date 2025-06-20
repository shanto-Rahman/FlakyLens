@Test public void bufferedSinkFlush() throws IOException {
assertEquals(0,sink.size());
assertEquals(0,bufferedSink.buffer().size());
assertEquals(1,sink.size());
}