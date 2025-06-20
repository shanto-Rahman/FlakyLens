@Test public void substringFromBeingIndex() throws Exception {
assertThat(abcd.substring(0).toString(),equalTo("ABCD"));
assertThat(abcd.substring(1).toString(),equalTo("BCD"));
assertThat(abcd.substring(2).toString(),equalTo("CD"));
assertThat(abcd.substring(3).toString(),equalTo("D"));
assertThat(abcd.substring(4).toString(),equalTo(""));
}