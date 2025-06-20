@Test public void inputStreamSkipMoreThanAvailable() throws Exception {
assertThat(this.inputStream.read(),equalTo(-1));
assertThat(amountSkipped,equalTo(256L));
}