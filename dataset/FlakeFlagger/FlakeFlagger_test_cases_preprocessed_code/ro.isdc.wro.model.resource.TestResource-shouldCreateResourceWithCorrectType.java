@Test public void shouldCreateResourceWithCorrectType(){
Assert.assertNotNull(resource);
Assert.assertEquals(ResourceType.JS,resource.getType());
Assert.assertNotNull(resource);
Assert.assertEquals(ResourceType.CSS,resource.getType());
}