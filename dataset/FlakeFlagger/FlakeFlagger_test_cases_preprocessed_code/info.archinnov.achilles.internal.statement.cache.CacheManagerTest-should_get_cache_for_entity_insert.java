@Test public void should_get_cache_for_entity_insert() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(cacheKey.<CompleteBean>getEntityClass()).isSameAs(CompleteBean.class);
assertThat(cacheKey.getType()).isEqualTo(CacheType.INSERT);
assertThat(cacheKey.getFields()).containsOnly("name","age");
}