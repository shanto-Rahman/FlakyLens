@Test void rendersTitleIfMessageSourceResolvesLocalKey() throws Exception {
  verifyResolvedTitle("_links.foobar.title");
}
