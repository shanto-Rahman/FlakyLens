@Test public void should_fail_with_PathsException_if_actual_cannot_be_resolved() throws IOException {
fail("expected a PathsException here");
assertThat(e).hasMessage("failed to resolve actual real path");
assertThat(e.getCause()).isSameAs(causeException);
}