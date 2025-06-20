@Test public void customJpaProperties() throws Exception {
assertThat(map.get("a"),equalTo((Object)"b"));
assertThat(map.get("c"),equalTo((Object)"d"));
assertThat(map.get("a.b"),equalTo((Object)"c"));
}