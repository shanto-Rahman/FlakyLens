@Test public void should_query_with_getLast() throws Exception {
assertThat(entity).isNull();
assertThat(entity.getValue()).isEqualTo("value5");
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo("value5");
assertThat(entities.get(1).getValue()).isEqualTo("value4");
assertThat(entities.get(2).getValue()).isEqualTo("value3");
}