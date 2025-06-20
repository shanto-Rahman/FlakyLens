@Test public void explicitFile(){
assertEquals(1,urls.size());
assertTrue(urls.get(0).startsWith("file:"));
}