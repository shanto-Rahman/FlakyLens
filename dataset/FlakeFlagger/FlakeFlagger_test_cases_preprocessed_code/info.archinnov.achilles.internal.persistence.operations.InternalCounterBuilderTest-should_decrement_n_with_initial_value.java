@Test public void should_decrement_n_with_initial_value() throws Exception {
assertThat(counter.get()).isEqualTo(8L);
assertThat(counter.getInternalCounterDelta()).isEqualTo(-2L);
}