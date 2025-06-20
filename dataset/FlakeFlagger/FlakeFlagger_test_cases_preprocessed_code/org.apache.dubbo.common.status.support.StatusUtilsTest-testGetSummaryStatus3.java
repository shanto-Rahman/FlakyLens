@Test public void testGetSummaryStatus3() throws Exception {
assertThat(status.getLevel(),is(Status.Level.OK));
assertThat(status.getMessage(),isEmptyOrNullString());
}