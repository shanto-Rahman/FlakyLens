@Test public void should_remove_with_default_params() throws Exception {
Thread.sleep(100);
assertThat(entities).hasSize(2);
assertThat(entities.get(0).getCounter().get()).isEqualTo(1L);
assertThat(entities.get(0).getVersion().get()).isEqualTo(1L);
assertThat(entities.get(1).getCounter().get()).isEqualTo(3L);
assertThat(entities.get(1).getVersion().get()).isEqualTo(3L);
}