@Test public void should_increment() throws Exception {
assertThat(counter.get()).isEqualTo(1L);
assertThat(counter.getInternalCounterDelta()).isEqualTo(1L);
}