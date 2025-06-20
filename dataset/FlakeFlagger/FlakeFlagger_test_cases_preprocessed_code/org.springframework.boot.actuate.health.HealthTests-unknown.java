@Test public void unknown() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UNKNOWN));
assertThat(health.getDetails().size(),equalTo(0));
}