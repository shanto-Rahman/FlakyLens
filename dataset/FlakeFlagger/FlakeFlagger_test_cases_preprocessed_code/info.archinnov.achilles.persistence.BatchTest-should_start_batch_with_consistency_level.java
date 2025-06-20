@Test public void should_start_batch_with_consistency_level() throws Exception {
assertThat(manager.flushContext).isSameAs(newFlushContext);
}