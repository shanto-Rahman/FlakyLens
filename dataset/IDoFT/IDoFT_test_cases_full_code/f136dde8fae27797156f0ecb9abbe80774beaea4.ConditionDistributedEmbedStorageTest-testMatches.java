@Test public void testMatches(){
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(true);
  Assert.assertFalse(conditionDistributedEmbedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(true);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(false);
  Assert.assertTrue(conditionDistributedEmbedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(false);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(true);
  Assert.assertFalse(conditionDistributedEmbedStorage.matches(context,metadata));
  Mockito.when(PropertyUtil.isEmbeddedStorage()).thenReturn(false);
  Mockito.when(EnvUtil.getStandaloneMode()).thenReturn(false);
  Assert.assertFalse(conditionDistributedEmbedStorage.matches(context,metadata));
}
