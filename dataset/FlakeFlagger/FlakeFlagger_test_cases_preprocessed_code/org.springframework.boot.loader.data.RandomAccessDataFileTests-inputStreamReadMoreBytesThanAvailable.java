@Test public void inputStreamReadMoreBytesThanAvailable() throws Exception {
assertThat(b,startsWith(BYTES));
assertThat(amountRead,equalTo(256));
}