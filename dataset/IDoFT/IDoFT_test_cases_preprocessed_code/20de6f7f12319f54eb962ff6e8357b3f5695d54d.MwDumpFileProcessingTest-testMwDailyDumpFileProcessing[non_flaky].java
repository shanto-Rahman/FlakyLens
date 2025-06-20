@Test public void testMwDailyDumpFileProcessing() throws IOException {
assertEquals("Wikidata Toolkit Test",tmrpAll.siteName);
assertEquals(revisionsAll.size(),mwrpAllStats.getTotalRevisionCount());
assertEquals(revisionsAll.size(),mwrpAllStats.getCurrentRevisionCount());
assertEquals(revisionsAllItems.size(),edpAllCounter.itemCount);
assertEquals(revisionsAllProperties.size(),edpAllCounter.propCount);
assertEquals(1,edpCurrentCounter.itemCount);
assertEquals(1,edpCurrentCounter.propCount);
}