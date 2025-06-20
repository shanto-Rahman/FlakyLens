@Test void testVanityUrl(){
assertTrue(underTest.accepts(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
assertEquals("/content/links/site1/en.html",underTest.sanitize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
assertEquals("/vanity.html",underTest.map(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
assertEquals("https://example.org/vanity.html",underTest.externalize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
}