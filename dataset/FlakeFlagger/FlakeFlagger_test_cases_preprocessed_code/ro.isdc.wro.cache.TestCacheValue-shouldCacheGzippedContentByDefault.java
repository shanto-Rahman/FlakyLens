@Test public void shouldCacheGzippedContentByDefault(){
Assert.assertNotNull(null,entry.getGzippedContentInternal());
Assert.assertNotNull(entry.getGzippedContent());
}