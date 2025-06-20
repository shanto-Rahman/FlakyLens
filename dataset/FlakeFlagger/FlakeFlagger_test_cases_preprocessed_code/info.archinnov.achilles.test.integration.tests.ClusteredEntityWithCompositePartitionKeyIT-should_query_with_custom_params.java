@Test public void should_query_with_custom_params() throws Exception {
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getValue()).isEqualTo("value3");
assertThat(entities.get(1).getValue()).isEqualTo("value2");
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo("value3");
assertThat(entities.get(1).getValue()).isEqualTo("value2");
assertThat(entities.get(2).getValue()).isEqualTo("value1");
}