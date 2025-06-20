@Test public void upWithDetails() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UP));
assertThat(health.getDetails().get("a"),equalTo((Object)"b"));
}