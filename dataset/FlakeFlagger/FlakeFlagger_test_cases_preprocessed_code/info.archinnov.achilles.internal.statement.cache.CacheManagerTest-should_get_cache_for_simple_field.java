@Test public void should_get_cache_for_simple_field() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(cacheKey.<CompleteBean>getEntityClass()).isSameAs(CompleteBean.class);
assertThat(cacheKey.getType()).isEqualTo(CacheType.SELECT_FIELD);
assertThat(cacheKey.getFields()).containsExactly("name");
}