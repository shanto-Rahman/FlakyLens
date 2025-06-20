@Test public void testDelegate() throws Exception {
assertThat(delegate.getMetadata(),sameInstance(service));
}