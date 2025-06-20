@Test public void bufferedSinkEmitsTailWhenItIsComplete() throws IOException {
assertEquals(0,sink.size());
assertEquals(Segment.SIZE,sink.size());
assertEquals(0,bufferedSink.buffer().size());
}