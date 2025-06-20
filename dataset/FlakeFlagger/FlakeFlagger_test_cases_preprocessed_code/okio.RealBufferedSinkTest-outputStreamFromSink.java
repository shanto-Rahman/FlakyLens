@Test public void outputStreamFromSink() throws Exception {
assertEquals("a" + repeat('b',9998) + "c",sink.readUtf8(10000));
}