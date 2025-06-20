@Test public void testMatches(){
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  Assert.assertTrue(conditionOnEmbeddedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(false);
  Assert.assertFalse(conditionOnEmbeddedStorage.matches(context,metadata));
}
