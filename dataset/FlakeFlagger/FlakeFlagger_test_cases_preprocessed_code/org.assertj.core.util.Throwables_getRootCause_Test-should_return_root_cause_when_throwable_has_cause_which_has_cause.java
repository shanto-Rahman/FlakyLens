@Test public void should_return_root_cause_when_throwable_has_cause_which_has_cause() throws Exception {
assertThat(Throwables.getRootCause(error)).isSameAs(expectedCause);
}