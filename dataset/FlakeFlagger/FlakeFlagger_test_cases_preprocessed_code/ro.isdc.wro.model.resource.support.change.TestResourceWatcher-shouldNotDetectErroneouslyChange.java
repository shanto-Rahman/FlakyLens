/** 
 * Fix the issue described <a href="https://github.com/alexo/wro4j/issues/72">here</a>.
 */
@Test public void shouldNotDetectErroneouslyChange() throws Exception {
resourceChanged.set(true);
groupChanged.set(true);
assertTrue(groupChanged.get());
assertTrue(resourceChanged.get());
groupChanged.set(false);
resourceChanged.set(false);
assertFalse(groupChanged.get());
assertFalse(resourceChanged.get());
}