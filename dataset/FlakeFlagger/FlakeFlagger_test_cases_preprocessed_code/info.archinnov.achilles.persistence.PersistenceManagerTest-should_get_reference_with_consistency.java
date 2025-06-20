@Test public void should_get_reference_with_consistency() throws Exception {
assertThat(bean).isSameAs(entity);
assertThat(options.getConsistencyLevel().get()).isSameAs(EACH_QUORUM);
assertThat(options.getTtl().isPresent()).isFalse();
assertThat(options.getTimestamp().isPresent()).isFalse();
}