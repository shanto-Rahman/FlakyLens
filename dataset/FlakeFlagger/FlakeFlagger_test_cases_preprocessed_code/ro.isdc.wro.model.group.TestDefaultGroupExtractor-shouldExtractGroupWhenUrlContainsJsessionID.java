@Test public void shouldExtractGroupWhenUrlContainsJsessionID(){
assertEquals("my",groupExtractor.getGroupName(request));
assertEquals(ResourceType.CSS,groupExtractor.getResourceType(request));
}