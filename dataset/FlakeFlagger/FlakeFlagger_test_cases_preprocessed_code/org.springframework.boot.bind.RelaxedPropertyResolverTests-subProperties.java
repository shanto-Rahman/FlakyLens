@Test public void subProperties() throws Exception {
assertThat(subProperties.size(),equalTo(3));
assertThat(subProperties.get("a.b"),equalTo((Object)"1"));
assertThat(subProperties.get("a.c"),equalTo((Object)"2"));
assertThat(subProperties.get("a.d"),equalTo((Object)"3"));
}