@Test public void testWithInvalidUriType(){
assertEquals("all",groupExtractor.getGroupName(request));
assertEquals(null,groupExtractor.getResourceType(request));
}