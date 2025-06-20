@Test public void faint() throws Exception {
assertThat(out,equalTo("\033[2min\033[0;39m"));
}