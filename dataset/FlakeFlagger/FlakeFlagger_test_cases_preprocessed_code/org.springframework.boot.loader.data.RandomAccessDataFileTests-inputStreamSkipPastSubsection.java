@Test public void inputStreamSkipPastSubsection() throws Exception {
assertThat(inputStream.skip(3),equalTo(2L));
assertThat(inputStream.read(),equalTo(-1));
}