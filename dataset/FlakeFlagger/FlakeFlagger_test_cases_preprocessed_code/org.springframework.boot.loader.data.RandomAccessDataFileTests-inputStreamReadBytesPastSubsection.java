@Test public void inputStreamReadBytesPastSubsection() throws Exception {
assertThat(b,equalTo(new byte[]{1,2,0}));
assertThat(amountRead,equalTo(2));
}