@Test public void fromEmpty() throws Exception {
assertThat(iterator.next(),equalTo(""));
assertThat(iterator.hasNext(),equalTo(false));
}