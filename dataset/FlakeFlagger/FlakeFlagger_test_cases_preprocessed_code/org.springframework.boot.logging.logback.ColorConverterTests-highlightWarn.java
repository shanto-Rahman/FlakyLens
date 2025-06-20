@Test public void highlightWarn() throws Exception {
assertThat(out,equalTo("\033[33min\033[0;39m"));
}