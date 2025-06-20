@Test public void should_throw_PathsException_if_actual_cannot_be_resolved() throws IOException {
fail("was expecting a PathsException here");
assertThat(e).hasMessage("failed to resolve actual real path");
assertThat(e.getCause()).isSameAs(exception);
}