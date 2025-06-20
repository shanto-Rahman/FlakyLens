@Test public void shouldExtractGroupWhenUrlContainsEncodedSession(){
assertEquals("all",groupExtractor.getGroupName(request));
assertEquals(ResourceType.JS,groupExtractor.getResourceType(request));
}