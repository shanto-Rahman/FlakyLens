@Test public void readInt() throws Exception {
assertEquals(0xabcdef01,data.readInt());
assertEquals(0x87654321,data.readInt());
assertEquals(0,data.size());
}