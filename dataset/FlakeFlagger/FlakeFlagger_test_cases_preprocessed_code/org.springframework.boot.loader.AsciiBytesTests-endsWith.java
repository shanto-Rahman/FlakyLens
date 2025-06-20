@Test public void endsWith() throws Exception {
assertThat(abc.endsWith(abc),equalTo(true));
assertThat(abc.endsWith(bc),equalTo(true));
assertThat(abc.endsWith(ab),equalTo(false));
assertThat(abc.endsWith(aabc),equalTo(false));
}