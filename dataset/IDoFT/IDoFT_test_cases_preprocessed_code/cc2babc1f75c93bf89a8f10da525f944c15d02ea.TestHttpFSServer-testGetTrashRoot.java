@Test @TestDir @TestJetty @TestHdfs public void testGetTrashRoot() throws Exception {
Assert.assertEquals(expectedPath.toUri().getPath(),trashPath);
Assert.assertEquals(expectedPath.toUri().getPath(),trashPath);
Assert.assertEquals(expectedPath.toUri().getPath(),trashPath);
}