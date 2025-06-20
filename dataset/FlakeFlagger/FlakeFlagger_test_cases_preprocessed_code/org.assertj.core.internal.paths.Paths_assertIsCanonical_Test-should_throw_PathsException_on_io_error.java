@Test public void should_throw_PathsException_on_io_error() throws IOException {
fail("Expected a PathsException here");
assertThat(e).hasMessage("failed to resolve actual real path");
assertThat(e.getCause()).isSameAs(exception);
}