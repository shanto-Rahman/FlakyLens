@Test public void testResoruceOfTypeFound(){
Assert.assertEquals(true,group.hasResourcesOfType(ResourceType.CSS));
Assert.assertEquals(false,group.hasResourcesOfType(ResourceType.JS));
}