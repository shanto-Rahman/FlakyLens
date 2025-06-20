@Test public void testFetchBehavior() throws IOException, ParseException {
assertNull("Failed to delete previous version",reader.getLocalFile(pdbId));
fail("LOCAL_ONLY shouldn't download files");
assertTrue("Wrong IOException reason",e.getMessage().contains("configured not to download"));
assertNull("Failed to delete previous version",reader.getLocalFile(pdbId));
assertNotNull("Failed to fetch structure",s);
assertEquals(prerem,location.lastModified());
assertNotNull("Failed to fetch structure",s);
assertTrue(location.exists());
assertTrue("Not re-downloaded",currMod > prerem);
assertNotNull("Failed to fetch structure",s);
assertTrue(location.exists());
assertEquals("Falsely re-downloaded",prerem,location.lastModified());
assertNotNull("Failed to fetch structure",s);
assertTrue(location.exists());
assertTrue("Not re-downloaded",currMod > prerem);
assertNotNull("Failed to fetch structure",s);
assertTrue("Not re-downloaded",currMod > d.getTime());
assertEquals("Falsely re-downloaded",currMod,location.lastModified());
}