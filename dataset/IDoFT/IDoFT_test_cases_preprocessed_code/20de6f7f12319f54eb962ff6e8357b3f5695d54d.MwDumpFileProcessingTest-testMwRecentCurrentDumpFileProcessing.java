@Test public void testMwRecentCurrentDumpFileProcessing() throws IOException {
assertEquals(5,mwrpStats.getTotalRevisionCount());
assertEquals(1,mwrpStats.getCurrentRevisionCount());
}