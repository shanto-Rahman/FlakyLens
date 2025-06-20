@Test public void testMatches(){
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(true);
  Assert.assertTrue(conditionStandaloneEmbedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(false);
  Assert.assertFalse(conditionStandaloneEmbedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(false);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(true);
  Assert.assertFalse(conditionStandaloneEmbedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(false);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(false);
  Assert.assertFalse(conditionStandaloneEmbedStorage.matches(context,metadata));
}
