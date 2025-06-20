@Test public void testCache() throws IOException {
Assert.assertNull(cache.get(key));
Assert.assertNotNull(entry);
Assert.assertEquals(hash,entry.getHash());
Assert.assertEquals(content,entry.getRawContent());
Assert.assertNull(cache.get(key));
Assert.assertNotNull(cache.get(key));
Assert.assertNull(cache.get(key));
}