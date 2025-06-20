@Test public void shouldStripJsessionIDFromUrl(){
assertEquals("all",groupExtractor.getGroupName(request));
assertEquals(ResourceType.JS,groupExtractor.getResourceType(request));
}