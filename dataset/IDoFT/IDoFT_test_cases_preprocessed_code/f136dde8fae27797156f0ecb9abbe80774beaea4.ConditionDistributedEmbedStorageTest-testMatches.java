@Test public void testMatches(){
Assert.assertFalse(conditionDistributedEmbedStorage.matches(context,metadata));
Assert.assertTrue(conditionDistributedEmbedStorage.matches(context,metadata));
Assert.assertFalse(conditionDistributedEmbedStorage.matches(context,metadata));
Assert.assertFalse(conditionDistributedEmbedStorage.matches(context,metadata));
}