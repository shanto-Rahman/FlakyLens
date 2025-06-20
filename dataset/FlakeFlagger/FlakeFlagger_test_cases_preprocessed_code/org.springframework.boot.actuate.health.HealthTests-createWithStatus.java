@Test public void createWithStatus() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UP));
assertThat(health.getDetails().size(),equalTo(0));
}