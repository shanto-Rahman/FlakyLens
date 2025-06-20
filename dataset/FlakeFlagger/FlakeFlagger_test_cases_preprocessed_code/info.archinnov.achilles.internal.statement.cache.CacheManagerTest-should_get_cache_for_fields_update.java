@Test public void should_get_cache_for_fields_update() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(cacheKey.<CompleteBean>getEntityClass()).isSameAs(CompleteBean.class);
assertThat(cacheKey.getType()).isEqualTo(CacheType.UPDATE_FIELDS);
assertThat(cacheKey.getFields()).containsOnly("name","age");
}