@Test public void startWith() throws Exception {
assertThat(abc.startsWith(abc),equalTo(true));
assertThat(abc.startsWith(ab),equalTo(true));
assertThat(abc.startsWith(bc),equalTo(false));
assertThat(abc.startsWith(abcd),equalTo(false));
}