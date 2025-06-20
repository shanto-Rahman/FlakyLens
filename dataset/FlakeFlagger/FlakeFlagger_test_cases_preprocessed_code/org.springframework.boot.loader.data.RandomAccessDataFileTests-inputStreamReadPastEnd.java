@Test public void inputStreamReadPastEnd() throws Exception {
assertThat(this.inputStream.read(),equalTo(0xFF));
assertThat(this.inputStream.read(),equalTo(-1));
assertThat(this.inputStream.read(),equalTo(-1));
}