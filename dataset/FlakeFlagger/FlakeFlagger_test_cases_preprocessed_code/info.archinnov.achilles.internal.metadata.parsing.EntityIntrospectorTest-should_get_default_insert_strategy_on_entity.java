@Test public void should_get_default_insert_strategy_on_entity() throws Exception {
assertThat(insertStrategy).isEqualTo(ALL_FIELDS);
}