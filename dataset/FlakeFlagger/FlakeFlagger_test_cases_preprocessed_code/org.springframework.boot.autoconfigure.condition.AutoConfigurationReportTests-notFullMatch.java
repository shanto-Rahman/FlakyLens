@Test public void notFullMatch() throws Exception {
assertThat(this.report.getConditionAndOutcomesBySource().get("a").isFullMatch(),equalTo(false));
}