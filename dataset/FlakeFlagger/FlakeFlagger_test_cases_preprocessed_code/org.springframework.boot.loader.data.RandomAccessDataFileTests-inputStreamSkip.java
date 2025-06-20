@Test public void inputStreamSkip() throws Exception {
assertThat(this.inputStream.read(),equalTo(4));
assertThat(amountSkipped,equalTo(4L));
}