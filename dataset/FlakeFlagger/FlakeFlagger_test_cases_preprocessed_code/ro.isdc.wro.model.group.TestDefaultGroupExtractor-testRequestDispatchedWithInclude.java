@Test public void testRequestDispatchedWithInclude(){
assertEquals("dispatched",groupExtractor.getGroupName(request));
assertEquals(null,groupExtractor.getResourceType(request));
}