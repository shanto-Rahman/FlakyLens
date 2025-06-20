@Test public void destroyTest() throws Exception {
Assert.assertEquals(1,abstractRegistry.getRegistered().size());
Assert.assertEquals(1,abstractRegistry.getSubscribed().get(testUrl).size());
Assert.assertEquals(0,abstractRegistry.getRegistered().size());
Assert.assertEquals(0,abstractRegistry.getSubscribed().get(testUrl).size());
}