@Test public void should_decrement_with_initial_value() throws Exception {
assertThat(counter.get()).isEqualTo(9L);
assertThat(counter.getInternalCounterDelta()).isEqualTo(-1L);
}