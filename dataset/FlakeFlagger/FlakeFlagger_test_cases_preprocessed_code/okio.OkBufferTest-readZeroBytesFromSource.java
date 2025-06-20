@Test public void readZeroBytesFromSource() throws Exception {
assertEquals(-1,source.read(sink,0));
assertEquals(10,sink.size());
assertEquals(0,source.size());
}