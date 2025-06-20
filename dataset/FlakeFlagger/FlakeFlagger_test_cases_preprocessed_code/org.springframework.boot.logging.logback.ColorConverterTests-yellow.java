@Test public void yellow() throws Exception {
assertThat(out,equalTo("\033[33min\033[0;39m"));
}