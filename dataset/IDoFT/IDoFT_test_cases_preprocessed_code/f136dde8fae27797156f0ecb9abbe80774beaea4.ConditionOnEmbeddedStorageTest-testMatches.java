@Test public void testMatches(){
Assert.assertTrue(conditionOnEmbeddedStorage.matches(context,metadata));
Assert.assertFalse(conditionOnEmbeddedStorage.matches(context,metadata));
}