@Test public void testReplaceWithFewResources(){
Assert.assertEquals(2,group.getResources().size());
Assert.assertEquals(resource.isMinimize(),group.getResources().get(0).isMinimize());
}