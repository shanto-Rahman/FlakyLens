@Test public void should_clean_batch() throws Exception {
assertThat(manager.flushContext).isSameAs(newFlushContext);
}