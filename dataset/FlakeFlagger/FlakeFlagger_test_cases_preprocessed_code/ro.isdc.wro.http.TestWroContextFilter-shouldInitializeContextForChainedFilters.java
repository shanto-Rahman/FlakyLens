@Test public void shouldInitializeContextForChainedFilters() throws Exception {
assertTrue(Context.isContextSet());
assertFalse(Context.isContextSet());
}