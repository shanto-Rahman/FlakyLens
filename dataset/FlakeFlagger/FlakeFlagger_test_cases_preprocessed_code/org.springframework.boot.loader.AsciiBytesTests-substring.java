@Test public void substring() throws Exception {
assertThat(abcd.substring(0,4).toString(),equalTo("ABCD"));
assertThat(abcd.substring(1,3).toString(),equalTo("BC"));
assertThat(abcd.substring(3,4).toString(),equalTo("D"));
assertThat(abcd.substring(3,3).toString(),equalTo(""));
}