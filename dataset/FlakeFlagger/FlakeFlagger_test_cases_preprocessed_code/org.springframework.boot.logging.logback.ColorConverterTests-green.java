@Test public void green() throws Exception {
assertThat(out,equalTo("\033[32min\033[0;39m"));
}