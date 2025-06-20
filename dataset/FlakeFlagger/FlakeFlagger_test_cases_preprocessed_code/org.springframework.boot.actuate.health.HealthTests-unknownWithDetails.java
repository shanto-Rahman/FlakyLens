@Test public void unknownWithDetails() throws Exception {
assertThat(health.getStatus(),equalTo(Status.UNKNOWN));
assertThat(health.getDetails().get("a"),equalTo((Object)"b"));
}