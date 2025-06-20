@Test public void testValidCssUri(){
assertEquals("group1",groupExtractor.getGroupName(request));
assertEquals(ResourceType.CSS,groupExtractor.getResourceType(request));
}