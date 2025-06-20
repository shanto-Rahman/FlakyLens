@Test public void should_dsl_select_with_token_value() throws Exception {
assertThat(actual).isNotNull();
assertThat(actual.getConsistencyList()).containsExactly(ConsistencyLevel.QUORUM,ConsistencyLevel.LOCAL_ONE);
assertThat(actual.getSimpleSet()).containsExactly(1.0,2.0);
assertThat(actual.getSimpleMap()).containsEntry(10,"ten");
assertThat(actual.getSimpleMap()).containsEntry(20,"twenty");
}