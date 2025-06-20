@Test public void statusCode() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UP));
assertThat(health.getDetails().size(),equalTo(0));
}