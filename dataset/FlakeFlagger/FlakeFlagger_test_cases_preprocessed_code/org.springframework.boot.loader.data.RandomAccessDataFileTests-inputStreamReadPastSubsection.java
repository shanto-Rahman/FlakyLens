@Test public void inputStreamReadPastSubsection() throws Exception {
assertThat(inputStream.read(),equalTo(1));
assertThat(inputStream.read(),equalTo(2));
assertThat(inputStream.read(),equalTo(-1));
}