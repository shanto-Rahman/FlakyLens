@Test public void withStackTrace() throws Exception {
assertThat(s,startsWith(LINE_SEPARATOR));
assertThat(s,endsWith(LINE_SEPARATOR));
}