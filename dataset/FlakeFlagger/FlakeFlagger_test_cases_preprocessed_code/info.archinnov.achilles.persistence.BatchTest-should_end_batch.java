@Test public void should_end_batch() throws Exception {
assertThat(manager.flushContext).isSameAs(newFlushContext);
}