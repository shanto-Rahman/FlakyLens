@Test public void should_fail_if_actual_and_expected_entries_have_different_size() throws Exception {
assertThat(e).hasMessage(shouldHaveSameSizeAs(linkedActual,linkedActual.size(),expected.length).create());
}