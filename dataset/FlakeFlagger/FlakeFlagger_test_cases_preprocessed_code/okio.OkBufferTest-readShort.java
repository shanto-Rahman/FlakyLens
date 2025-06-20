@Test public void readShort() throws Exception {
assertEquals((short)0xabcd,data.readShort());
assertEquals((short)0xef01,data.readShort());
assertEquals(0,data.size());
}