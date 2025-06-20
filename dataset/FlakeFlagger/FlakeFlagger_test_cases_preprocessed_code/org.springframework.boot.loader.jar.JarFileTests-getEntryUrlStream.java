@Test public void getEntryUrlStream() throws Exception {
assertThat(stream.read(),equalTo(1));
assertThat(stream.read(),equalTo(-1));
}