@Test public void withException() throws Exception {
assertThat(health.getDetails().get("a"),equalTo((Object)"b"));
assertThat(health.getDetails().get("error"),equalTo((Object)"java.lang.RuntimeException: bang"));
}