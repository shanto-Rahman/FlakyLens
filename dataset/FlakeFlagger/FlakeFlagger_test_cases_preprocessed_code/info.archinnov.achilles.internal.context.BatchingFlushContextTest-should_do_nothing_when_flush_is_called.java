@Test public void should_do_nothing_when_flush_is_called() throws Exception {
assertThat(context.statementWrappers).containsExactly(bsWrapper);
}