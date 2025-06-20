@Test public void createWithDetails() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UP));
assertThat(health.getDetails().get("a"),equalTo((Object)"b"));
}