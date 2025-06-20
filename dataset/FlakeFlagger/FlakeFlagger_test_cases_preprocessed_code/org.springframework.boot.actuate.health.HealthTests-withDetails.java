@Test public void withDetails() throws Exception {
assertThat(health.getDetails().get("a"),equalTo((Object)"b"));
assertThat(health.getDetails().get("c"),equalTo((Object)"d"));
}