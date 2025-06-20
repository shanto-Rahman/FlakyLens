@Test public void testFetchBehavior() throws IOException, ParseException {
  String pdbId="1hh0";
  LocalPDBDirectory reader=new MMCIFFileReader(cache.getPath());
  reader.deleteStructure(pdbId);
  assertNull("Failed to delete previous version",reader.getLocalFile(pdbId));
  reader.setFetchBehavior(FetchBehavior.LOCAL_ONLY);
  Structure s;
  try {
    s=reader.getStructureById(pdbId);
    fail("LOCAL_ONLY shouldn't download files");
  }
 catch (  IOException e) {
    assertTrue("Wrong IOException reason",e.getMessage().contains("configured not to download"));
  }
  reader.deleteStructure(pdbId);
  assertNull("Failed to delete previous version",reader.getLocalFile(pdbId));
  reader.setFetchBehavior(FetchBehavior.FETCH_FILES);
  s=reader.getStructureById(pdbId);
  assertNotNull("Failed to fetch structure",s);
  File location=reader.getLocalFile(pdbId);
  long prerem=LocalPDBDirectory.LAST_REMEDIATION_DATE - 1000 * 60 * 60* 25;
  location.setLastModified(prerem);
  assertEquals(prerem,location.lastModified());
  reader.setFetchBehavior(FetchBehavior.FORCE_DOWNLOAD);
  s=reader.getStructureById(pdbId);
  assertNotNull("Failed to fetch structure",s);
  location=reader.getLocalFile(pdbId);
  assertTrue(location.exists());
  long currMod=location.lastModified();
  assertTrue("Not re-downloaded",currMod > prerem);
  reader.setFetchBehavior(FetchBehavior.LOCAL_ONLY);
  s=reader.getStructureById(pdbId);
  assertNotNull("Failed to fetch structure",s);
  location.setLastModified(prerem);
  reader.setFetchBehavior(FetchBehavior.FETCH_FILES);
  s=reader.getStructureById(pdbId);
  location=reader.getLocalFile(pdbId);
  assertTrue(location.exists());
  assertEquals("Falsely re-downloaded",prerem,location.lastModified());
  reader.setFetchBehavior(FetchBehavior.FETCH_REMEDIATED);
  s=reader.getStructureById(pdbId);
  assertNotNull("Failed to fetch structure",s);
  location=reader.getLocalFile(pdbId);
  assertTrue(location.exists());
  currMod=location.lastModified();
  assertTrue("Not re-downloaded",currMod > prerem);
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd",Locale.US);
  Date d=formatter.parse("2000/01/01");
  location.setLastModified(d.getTime());
  reader.setFetchBehavior(FetchBehavior.FETCH_IF_OUTDATED);
  s=reader.getStructureById(pdbId);
  assertNotNull("Failed to fetch structure",s);
  currMod=location.lastModified();
  assertTrue("Not re-downloaded",currMod > d.getTime());
  reader.setFetchBehavior(FetchBehavior.FETCH_IF_OUTDATED);
  location=reader.getLocalFile(pdbId);
  currMod=location.lastModified();
  s=reader.getStructureById(pdbId);
  assertEquals("Falsely re-downloaded",currMod,location.lastModified());
}
