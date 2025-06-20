@Test public void should_load_clustered_counter() throws Throwable {
assertThat(actual).isNull();
assertThat(counter.get()).isNull();
assertThat(counter.getInternalCounterDelta()).isNull();
}