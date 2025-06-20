@Test public void readExhaustedSource() throws Exception {
assertEquals(-1,source.read(sink,10));
assertEquals(10,sink.size());
assertEquals(0,source.size());
}