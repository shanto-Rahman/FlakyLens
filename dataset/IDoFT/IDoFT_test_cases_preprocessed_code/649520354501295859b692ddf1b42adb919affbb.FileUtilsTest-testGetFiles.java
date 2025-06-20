@Test public void testGetFiles() throws URISyntaxException {
assertTrue(directory.exists());
assertFalse(foundFiles.isEmpty());
assertEquals(foundFiles,foundFiles2);
}