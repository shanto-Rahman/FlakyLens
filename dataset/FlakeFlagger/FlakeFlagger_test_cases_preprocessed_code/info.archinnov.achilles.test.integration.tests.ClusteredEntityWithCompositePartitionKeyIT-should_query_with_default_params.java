@Test public void should_query_with_default_params() throws Exception {
assertThat(entities).isEmpty();
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getValue()).isEqualTo("value1");
assertThat(entities.get(0).getId().getId()).isEqualTo(id);
assertThat(entities.get(0).getId().getType()).isEqualTo("type");
assertThat(entities.get(0).getId().getIndexes()).isEqualTo(11);
assertThat(entities.get(1).getValue()).isEqualTo("value2");
assertThat(entities.get(1).getId().getId()).isEqualTo(id);
assertThat(entities.get(1).getId().getType()).isEqualTo("type");
assertThat(entities.get(1).getId().getIndexes()).isEqualTo(12);
}