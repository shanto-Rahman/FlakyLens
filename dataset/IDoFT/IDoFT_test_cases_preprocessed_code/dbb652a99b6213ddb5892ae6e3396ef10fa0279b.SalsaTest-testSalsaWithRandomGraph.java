@Test public void testSalsaWithRandomGraph() throws Exception {
assertEquals(expectedSalsaStats,salsaResponse.getSalsaStats());
assertEquals(expectedTopResults,salsaResults);
}