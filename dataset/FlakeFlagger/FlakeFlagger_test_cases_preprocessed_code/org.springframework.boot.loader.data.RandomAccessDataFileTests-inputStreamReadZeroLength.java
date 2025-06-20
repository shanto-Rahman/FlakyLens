@Test public void inputStreamReadZeroLength() throws Exception {
assertThat(b,equalTo(new byte[]{0x0F}));
assertThat(amountRead,equalTo(0));
assertThat(this.inputStream.read(),equalTo(0));
}