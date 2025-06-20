@Test public void fromPlain() throws Exception {
assertThat(iterator.next(),equalTo("plain"));
assertThat(iterator.next(),equalTo("PLAIN"));
assertThat(iterator.hasNext(),equalTo(false));
}