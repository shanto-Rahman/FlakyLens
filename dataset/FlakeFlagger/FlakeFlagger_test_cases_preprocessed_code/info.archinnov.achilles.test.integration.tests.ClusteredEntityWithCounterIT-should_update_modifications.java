@Test public void should_update_modifications() throws Exception {
assertThat(entity.getCounter().get()).isEqualTo(initialValue);
assertThat(entity.getCounter().get()).isEqualTo(initialValue + increment);
assertThat(entity.getVersion().get()).isEqualTo(initialValue + increment);
}