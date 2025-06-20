@Test public void status() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UP));
assertThat(health.getDetails().size(),equalTo(0));
}