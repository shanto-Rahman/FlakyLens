@Test public void testMatches(){
Assert.assertTrue(conditionStandaloneEmbedStorage.matches(context,metadata));
Assert.assertFalse(conditionStandaloneEmbedStorage.matches(context,metadata));
Assert.assertFalse(conditionStandaloneEmbedStorage.matches(context,metadata));
Assert.assertFalse(conditionStandaloneEmbedStorage.matches(context,metadata));
}