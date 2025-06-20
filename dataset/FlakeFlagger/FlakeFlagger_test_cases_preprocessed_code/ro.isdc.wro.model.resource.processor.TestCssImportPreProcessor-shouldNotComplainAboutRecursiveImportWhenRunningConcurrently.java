/** 
 * Fixes <a href="http://code.google.com/p/wro4j/issues/detail?id=505">CssImport processor recursion detection is not thread-safe</a> issue.
 */
@Test public void shouldNotComplainAboutRecursiveImportWhenRunningConcurrently() throws Exception {
contextMapRef.set(getContextMap());
if (new Random().nextBoolean()) {
}
assertTrue(contextMapRef.get().isEmpty());
}