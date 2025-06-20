@Test public void should_remove_with_default_params() throws Exception {
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getValue()).isEqualTo("value1");
assertThat(entities.get(1).getValue()).isEqualTo("value3");
}