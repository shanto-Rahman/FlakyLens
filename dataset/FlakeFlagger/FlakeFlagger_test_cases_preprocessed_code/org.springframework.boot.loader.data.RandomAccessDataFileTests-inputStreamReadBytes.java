@Test public void inputStreamReadBytes() throws Exception {
assertThat(b,equalTo(BYTES));
assertThat(amountRead,equalTo(256));
}