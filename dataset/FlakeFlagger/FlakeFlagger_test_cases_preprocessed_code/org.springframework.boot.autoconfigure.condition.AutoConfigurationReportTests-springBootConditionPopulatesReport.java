@Test @SuppressWarnings("resource") public void springBootConditionPopulatesReport() throws Exception {
assertThat(report.getConditionAndOutcomesBySource().size(),not(equalTo(0)));
}