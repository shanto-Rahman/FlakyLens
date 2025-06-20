@Test public void should_return_cause_when_throwable_has_cause() throws Exception {
assertThat(Throwables.getRootCause(new Throwable(expectedCause))).isSameAs(expectedCause);
}