@Test public void should_start_batch() throws Exception {
assertThat(manager.flushContext).isSameAs(newFlushContext);
}