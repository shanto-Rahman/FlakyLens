@Test public void testGetSummaryStatus2() throws Exception {
assertThat(status.getLevel(),is(Status.Level.WARN));
assertThat(status.getMessage(),containsString("status1"));
assertThat(status.getMessage(),not(containsString("status2")));
}