@Test public void testGetFiles() throws URISyntaxException {
  URL resource=FileUtilsTest.class.getResource("FileUtilsTest.class");
  File directory=Paths.get(resource.toURI()).getParent().toFile();
  assertTrue(directory.exists());
  List<File> foundFiles=FileUtils.getFilesUsingSuffix(directory,".class");
  assertFalse(foundFiles.isEmpty());
  List<File> foundFiles2=FileUtils.getFiles(directory,".*\\.class$");
  assertEquals(foundFiles,foundFiles2);
}
