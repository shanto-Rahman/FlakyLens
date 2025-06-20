@Test public void should_build_dao_context_without_counter() throws Exception {
assertThat(Whitebox.<Map<Class<?>,PreparedStatement>>getInternalState(actual,"selectPSs")).containsValue(selectEagerPS);
assertThat(Whitebox.<Map<Class<?>,Map<String,PreparedStatement>>>getInternalState(actual,"removePSs")).containsKey(CompleteBean.class);
assertThat(Whitebox.<Cache<StatementCacheKey,PreparedStatement>>getInternalState(actual,"dynamicPSCache")).isInstanceOf(Cache.class);
assertThat(Whitebox.<Map<CQLQueryType,PreparedStatement>>getInternalState(actual,"counterQueryMap")).isEmpty();
}