@Test public void should_initialize_counter_value() throws Exception {
assertThat(rawEntity.getVersion()).isInstanceOf(InternalCounterImpl.class);
assertThat(rawEntity.getVersion().get()).isEqualTo(2L);
}