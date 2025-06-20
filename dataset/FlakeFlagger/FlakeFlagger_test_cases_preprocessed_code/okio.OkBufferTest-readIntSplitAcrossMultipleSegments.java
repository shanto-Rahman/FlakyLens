@Test public void readIntSplitAcrossMultipleSegments() throws Exception {
assertEquals(0xabcdef01,data.readInt());
assertEquals(0,data.size());
}