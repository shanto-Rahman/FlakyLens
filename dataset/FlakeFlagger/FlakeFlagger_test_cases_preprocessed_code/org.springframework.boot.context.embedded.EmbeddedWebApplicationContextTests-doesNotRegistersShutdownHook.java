@Test public void doesNotRegistersShutdownHook() throws Exception {
assertThat(shutdownHook,nullValue());
}