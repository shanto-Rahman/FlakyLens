@Test public void outOfService() throws Exception {
assertThat(health.getStatus(),equalTo(Status.OUT_OF_SERVICE));
assertThat(health.getDetails().size(),equalTo(0));
}