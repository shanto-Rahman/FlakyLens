@Test public void testMwMostRecentFullDumpFileProcessing() throws IOException {
assertEquals(9,mwrpStats.getTotalRevisionCount());
assertEquals(9,mwrpStats.getCurrentRevisionCount());
}