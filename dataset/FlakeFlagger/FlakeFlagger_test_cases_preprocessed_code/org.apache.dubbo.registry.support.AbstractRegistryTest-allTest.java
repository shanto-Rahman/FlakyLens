@Test public void allTest() throws Exception {
Assert.assertTrue(abstractRegistry.getRegistered().contains(testUrl));
Assert.assertTrue(abstractRegistry.getSubscribed().containsKey(testUrl));
Assert.assertFalse(notifySuccess);
Assert.assertTrue(notifySuccess);
Assert.assertFalse(abstractRegistry.getSubscribed().containsKey(listener));
Assert.assertFalse(abstractRegistry.getRegistered().contains(testUrl));
}