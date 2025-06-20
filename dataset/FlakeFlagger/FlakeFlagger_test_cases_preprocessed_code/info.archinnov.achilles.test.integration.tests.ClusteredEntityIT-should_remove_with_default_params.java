@Test public void should_remove_with_default_params() throws Exception {
assertThat(entities).hasSize(3);
assertThat(entities.get(0).getId().getCount()).isEqualTo(1);
assertThat(entities.get(0).getValue()).isEqualTo(clusteredValuePrefix + 1);
assertThat(entities.get(1).getId().getCount()).isEqualTo(1);
assertThat(entities.get(1).getValue()).isEqualTo(clusteredValuePrefix + 2);
assertThat(entities.get(2).getId().getCount()).isEqualTo(3);
assertThat(entities.get(2).getValue()).isEqualTo(clusteredValuePrefix + 1);
}