@Test public void shouldCollectCorrectNumberOfResourcesByType(){
Assert.assertEquals(6,group.collectResourcesOfType(ResourceType.JS).getResources().size());
Assert.assertEquals(1,group.collectResourcesOfType(ResourceType.CSS).getResources().size());
}