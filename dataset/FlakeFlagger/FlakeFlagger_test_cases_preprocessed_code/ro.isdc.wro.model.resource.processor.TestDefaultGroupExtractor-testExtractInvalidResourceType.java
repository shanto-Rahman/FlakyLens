@Test public void testExtractInvalidResourceType(){
Assert.assertEquals(ResourceType.JS,type);
Assert.assertEquals(ResourceType.CSS,type);
Assert.assertNull(victim.getResourceType(mockRequestForUri(uri)));
}