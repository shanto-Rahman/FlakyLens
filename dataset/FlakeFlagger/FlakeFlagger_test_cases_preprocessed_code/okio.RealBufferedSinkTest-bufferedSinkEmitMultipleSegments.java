@Test public void bufferedSinkEmitMultipleSegments() throws IOException {
assertEquals(Segment.SIZE * 3,sink.size());
assertEquals(Segment.SIZE - 1,bufferedSink.buffer().size());
}