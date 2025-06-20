@Test public void should_collect_all_errors_when_using_flat_extracting() throws Exception {
softly.assertThat(characters).flatExtracting(children()).overridingErrorMessage("error 1").hasSize(0).overridingErrorMessage("error 2").isEmpty();
assertThat(e.getErrors()).containsExactly("error 1","error 2");
}