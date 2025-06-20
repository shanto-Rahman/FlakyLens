@Test public void should_throw_error_wrapping_catched_IOException() throws IOException {
assertThat(e.getCause()).isSameAs(cause);
}