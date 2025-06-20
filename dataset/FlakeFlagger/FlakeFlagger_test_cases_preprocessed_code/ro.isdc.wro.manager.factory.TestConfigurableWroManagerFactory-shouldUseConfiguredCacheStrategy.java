@Test public void shouldUseConfiguredCacheStrategy() throws Exception {
assertEquals(MemoryCacheStrategy.class,actual.getClass());
}