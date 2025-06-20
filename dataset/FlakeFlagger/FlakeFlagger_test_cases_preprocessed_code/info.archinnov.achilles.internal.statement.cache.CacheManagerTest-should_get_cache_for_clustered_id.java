@Test public void should_get_cache_for_clustered_id() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(cacheKey.getFields()).containsOnly("id","a","b");
}