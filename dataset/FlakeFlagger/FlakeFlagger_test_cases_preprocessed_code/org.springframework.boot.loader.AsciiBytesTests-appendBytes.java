@Test public void appendBytes() throws Exception {
assertThat(bc.toString(),equalTo("BC"));
assertThat(appended.toString(),equalTo("BCD"));
}