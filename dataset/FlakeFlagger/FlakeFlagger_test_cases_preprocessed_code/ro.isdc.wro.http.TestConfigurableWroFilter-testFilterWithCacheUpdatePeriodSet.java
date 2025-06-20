@Test public void testFilterWithCacheUpdatePeriodSet() throws Exception {
assertEquals(20,Context.get().getConfig().getCacheUpdatePeriod());
}