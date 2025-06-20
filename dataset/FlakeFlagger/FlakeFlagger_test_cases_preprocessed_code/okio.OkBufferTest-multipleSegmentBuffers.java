@Test public void multipleSegmentBuffers() throws Exception {
assertEquals(repeat('a',999),buffer.readUtf8(999));
assertEquals("a" + repeat('b',2500) + "c",buffer.readUtf8(2502));
assertEquals(repeat('c',4998),buffer.readUtf8(4998));
assertEquals("c" + repeat('d',10000) + "e",buffer.readUtf8(10002));
assertEquals(repeat('e',24998),buffer.readUtf8(24998));
assertEquals("e" + repeat('f',50000),buffer.readUtf8(50001));
assertEquals(0,buffer.size());
}