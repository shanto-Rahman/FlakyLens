@Test public void readByte() throws Exception {
assertEquals(0xab,data.readByte() & 0xff);
assertEquals(0xcd,data.readByte() & 0xff);
assertEquals(0,data.size());
}