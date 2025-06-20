@Test public void testGetSummaryStatus1() throws Exception {
assertThat(status.getLevel(),is(Status.Level.ERROR));
assertThat(status.getMessage(),containsString("status1"));
assertThat(status.getMessage(),containsString("status2"));
assertThat(status.getMessage(),not(containsString("status3")));
}