@Test public void shouldContainWebjarLocator(){
if (locator instanceof WebjarUriLocator) {
}
assertTrue(hasWebjarLocator);
}