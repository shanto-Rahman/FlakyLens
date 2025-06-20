@Test public void fullMatch() throws Exception {
assertThat(this.report.getConditionAndOutcomesBySource().get("a").isFullMatch(),equalTo(true));
}