@Test public void testFetchObsolete() throws IOException, StructureException {
  cache.setFetchBehavior(FetchBehavior.FETCH_FILES);
  cache.setObsoleteBehavior(ObsoleteBehavior.FETCH_OBSOLETE);
  Structure s;
  cache.setUseMmtf(false);
  cache.setUseMmCif(false);
  s=cache.getStructure("1CMW");
  assertEquals("Failed to get OBSOLETE file 1CMW.","1CMW",s.getPDBCode());
  s=cache.getStructure("1HHB");
  assertEquals("Failed to get OBSOLETE file 1HHB.","1HHB",s.getPDBCode());
  cache.setUseMmCif(true);
  s=cache.getStructure("1CMW");
  assertEquals("Failed to get OBSOLETE file 1CMW.","1CMW",s.getPDBCode());
  s=cache.getStructure("1HHB");
  assertEquals("Failed to get OBSOLETE file 1HHB.","1HHB",s.getPDBCode());
}
