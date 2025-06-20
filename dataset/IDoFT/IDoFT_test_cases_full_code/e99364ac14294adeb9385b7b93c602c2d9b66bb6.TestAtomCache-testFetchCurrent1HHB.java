@Test public void testFetchCurrent1HHB() throws IOException, StructureException {
  cache.setFetchBehavior(FetchBehavior.FETCH_FILES);
  cache.setObsoleteBehavior(ObsoleteBehavior.FETCH_CURRENT);
  cache.setUseMmCif(false);
  Structure s=cache.getStructure("1HHB");
  assertEquals("Failed to get the current ID for 1HHB.","4HHB",s.getPDBCode());
  cache.setUseMmCif(true);
  s=cache.getStructure("1HHB");
  assertEquals("Failed to get the current ID for 1HHB.","4HHB",s.getPDBCode());
}
