@Test void rendersTitleIfMessageSourceResolvesNamespacedKey() throws Exception {
  verifyResolvedTitle("_links.ns:foobar.title");
}
