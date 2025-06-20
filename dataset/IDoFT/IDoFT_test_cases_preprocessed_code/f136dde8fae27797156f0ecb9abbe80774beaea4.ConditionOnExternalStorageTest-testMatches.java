@Test public void testMatches(){
Assert.assertFalse(conditionOnExternalStorage.matches(context,metadata));
Assert.assertTrue(conditionOnExternalStorage.matches(context,metadata));
}