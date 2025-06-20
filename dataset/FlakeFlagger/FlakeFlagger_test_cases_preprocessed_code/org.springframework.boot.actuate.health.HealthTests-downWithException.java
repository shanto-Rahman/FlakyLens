@Test public void downWithException() throws Exception {
assertThat(health.getStatus(),equalTo(Status.DOWN));
assertThat(health.getDetails().get("error"),equalTo((Object)"java.lang.RuntimeException: bang"));
}