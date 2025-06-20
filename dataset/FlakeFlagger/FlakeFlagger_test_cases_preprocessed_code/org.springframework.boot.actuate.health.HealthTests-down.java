@Test public void down() throws Exception {
assertThat(health.getStatus(),equalTo(Status.DOWN));
assertThat(health.getDetails().size(),equalTo(0));
}