@Test public void directoryOfFilesWithPrefix(){
assertEquals(1,urls.size());
assertTrue(urls.get(0).startsWith("file:"));
}