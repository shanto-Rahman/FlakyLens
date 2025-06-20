@Test public void testMatches(){
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  Assert.assertFalse(conditionOnExternalStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(false);
  Assert.assertTrue(conditionOnExternalStorage.matches(context,metadata));
}
