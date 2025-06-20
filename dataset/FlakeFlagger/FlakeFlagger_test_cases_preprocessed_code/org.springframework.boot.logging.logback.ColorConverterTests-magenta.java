@Test public void magenta() throws Exception {
assertThat(out,equalTo("\033[35min\033[0;39m"));
}