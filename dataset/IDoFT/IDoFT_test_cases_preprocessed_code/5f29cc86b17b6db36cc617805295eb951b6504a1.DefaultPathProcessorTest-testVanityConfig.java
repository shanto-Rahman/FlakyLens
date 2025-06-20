@Test void testVanityConfig(){
assertEquals("/content/site1/en.html",underTest.map(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
assertEquals("https://example.org/content/links/site1/en.html",underTest.externalize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
assertEquals("/cp/vanity.html",underTest.sanitize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
}