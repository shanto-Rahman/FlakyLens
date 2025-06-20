@Test public void parentBottomUp() throws Exception {
assertThat(this.report,not(nullValue()));
assertThat(this.report,not(sameInstance(this.report.getParent())));
assertThat(this.report.getParent(),not(nullValue()));
assertThat(this.report.getParent().getParent(),nullValue());
}