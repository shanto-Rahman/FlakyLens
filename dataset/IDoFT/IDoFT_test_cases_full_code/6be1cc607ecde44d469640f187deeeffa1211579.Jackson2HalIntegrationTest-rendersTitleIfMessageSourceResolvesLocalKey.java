/** 
 * @see #378
 */
@Test void rendersTitleIfMessageSourceResolvesLocalKey() throws Exception {
  verifyResolvedTitle("_links.foobar.title");
}
