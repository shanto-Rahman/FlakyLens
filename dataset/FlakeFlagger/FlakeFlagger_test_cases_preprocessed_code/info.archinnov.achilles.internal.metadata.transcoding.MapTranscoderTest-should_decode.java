@Test public void should_decode() throws Exception {
assertThat(actual).containsKey(1);
assertThat(actual).containsValue("value");
}