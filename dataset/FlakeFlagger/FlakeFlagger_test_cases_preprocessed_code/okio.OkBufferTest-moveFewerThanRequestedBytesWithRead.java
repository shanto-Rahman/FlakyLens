@Test public void moveFewerThanRequestedBytesWithRead() throws Exception {
assertEquals(20,source.read(sink,25));
assertEquals(30,sink.size());
assertEquals(0,source.size());
assertEquals(repeat('a',10) + repeat('b',20),sink.readUtf8(30));
}