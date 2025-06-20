@Test public void should_query_with_custom_params() throws Exception {
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 3);
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 3);
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(entities.get(2).getValue()).isEqualTo(clusteredValuePrefix + 1);
}