@Test public void should_generate_update_prepared_statement_when_not_found_in_cache() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(cacheKey.<CompleteBean>getEntityClass()).isSameAs(CompleteBean.class);
assertThat(cacheKey.getType()).isEqualTo(CacheType.UPDATE_FIELDS);
assertThat(cacheKey.getFields()).containsOnly("name","age");
}