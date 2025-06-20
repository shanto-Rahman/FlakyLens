@Test public void should_get_insert_strategy_on_entity() throws Exception {
assertThat(insertStrategy).isEqualTo(NOT_NULL_FIELDS);
}