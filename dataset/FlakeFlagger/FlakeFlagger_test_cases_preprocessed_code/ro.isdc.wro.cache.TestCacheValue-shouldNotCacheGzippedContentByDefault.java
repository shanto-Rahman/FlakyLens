@Test public void shouldNotCacheGzippedContentByDefault(){
Assert.assertEquals(RAW_CONTENT,entry.getRawContent());
Assert.assertNull(entry.getGzippedContentInternal());
Assert.assertNotNull(entry.getGzippedContent());
}