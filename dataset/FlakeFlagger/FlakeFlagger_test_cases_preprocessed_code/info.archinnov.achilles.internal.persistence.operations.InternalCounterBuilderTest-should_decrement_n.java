@Test public void should_decrement_n() throws Exception {
assertThat(counter.get()).isEqualTo(-5L);
assertThat(counter.getInternalCounterDelta()).isEqualTo(-5L);
}