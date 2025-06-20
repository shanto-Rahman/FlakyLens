@Test public void should_query_with_getFirst() throws Exception {
assertThat(entity).isNull();
assertThat(entity.getValue()).isEqualTo("value1");
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo("value1");
assertThat(entities.get(1).getValue()).isEqualTo("value2");
assertThat(entities.get(2).getValue()).isEqualTo("value3");
}