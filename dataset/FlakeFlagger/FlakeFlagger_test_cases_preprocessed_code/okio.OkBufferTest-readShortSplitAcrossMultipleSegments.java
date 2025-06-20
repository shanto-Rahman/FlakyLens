@Test public void readShortSplitAcrossMultipleSegments() throws Exception {
assertEquals((short)0xabcd,data.readShort());
assertEquals(0,data.size());
}