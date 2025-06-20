@Test public void testGetResource() throws Exception {
File resFile=resMan.getResource(resourceFile.getName());//RW
assertTrue(resFile.exists());
assertEquals(resContent,RESOURCE_FILE_CONTENT);
}