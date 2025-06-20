@Test public void highlightError() throws Exception {
assertThat(out,equalTo("\033[31min\033[0;39m"));
}