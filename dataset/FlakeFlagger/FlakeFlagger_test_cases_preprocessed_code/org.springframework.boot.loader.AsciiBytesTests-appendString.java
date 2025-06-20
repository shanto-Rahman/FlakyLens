@Test public void appendString() throws Exception {
assertThat(bc.toString(),equalTo("BC"));
assertThat(appended.toString(),equalTo("BCD"));
}