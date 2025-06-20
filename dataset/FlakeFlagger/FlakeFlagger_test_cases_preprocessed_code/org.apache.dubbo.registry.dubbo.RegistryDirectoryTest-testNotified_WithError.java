@Test public void testNotified_WithError(){
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(1,invokers.size());
}