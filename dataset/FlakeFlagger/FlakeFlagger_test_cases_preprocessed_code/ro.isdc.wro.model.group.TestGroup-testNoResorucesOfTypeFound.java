@Test public void testNoResorucesOfTypeFound(){
Assert.assertEquals(false,group.hasResourcesOfType(ResourceType.CSS));
Assert.assertEquals(false,group.hasResourcesOfType(ResourceType.JS));
}