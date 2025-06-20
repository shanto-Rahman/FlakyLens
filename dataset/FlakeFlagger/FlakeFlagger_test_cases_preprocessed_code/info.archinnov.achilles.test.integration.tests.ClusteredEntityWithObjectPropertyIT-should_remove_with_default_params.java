@Test public void should_remove_with_default_params() throws Exception {
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getValue().getContent()).isEqualTo("name1");
assertThat(entities.get(1).getValue().getContent()).isEqualTo("name3");
}