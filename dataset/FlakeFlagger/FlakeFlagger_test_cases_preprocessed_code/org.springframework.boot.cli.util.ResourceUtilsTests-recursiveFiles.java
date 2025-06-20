@Test public void recursiveFiles(){
assertEquals(1,urls.size());
assertTrue(urls.get(0).startsWith("file:"));
}