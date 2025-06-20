@Test public void testValidJsUri(){
assertEquals("otherGroup",groupExtractor.getGroupName(request));
assertEquals(ResourceType.JS,groupExtractor.getResourceType(request));
}