@Test public void should_get_reference() throws Exception {
assertThat(bean).isSameAs(entity);
assertThat(options.getConsistencyLevel().isPresent()).isFalse();
assertThat(options.getTtl().isPresent()).isFalse();
assertThat(options.getTimestamp().isPresent()).isFalse();
}