@Test public void should_fail_if_expected_parent_cannot_be_canonicalized() throws IOException {
fail("expected a PathsException here");
assertThat(e).hasMessage("failed to resolve argument real path");
assertThat(e.getCause()).isSameAs(exception);
}