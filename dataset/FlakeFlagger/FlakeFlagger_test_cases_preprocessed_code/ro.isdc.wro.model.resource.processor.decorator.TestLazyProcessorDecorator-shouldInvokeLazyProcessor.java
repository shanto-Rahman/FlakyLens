@Test public void shouldInvokeLazyProcessor() throws Exception {
assertTrue(victim.isMinimize());
assertFalse(victim.isSupported());
assertEquals(expectedResourceType,victim.getSupportedResourceType().value());
}