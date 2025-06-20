@Test void testVanityUrl(){
  Page page=context.create().page("/content/links/site1/en","/conf/example",ImmutableMap.of("sling:vanityPath","vanity.html"));
  DefaultPathProcessor underTest=context.registerInjectActivateService(new DefaultPathProcessor(),ImmutableMap.of("vanityConfig",DefaultPathProcessor.VanityConfig.MAPPING.getValue()));
  assertTrue(underTest.accepts(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
  assertEquals("/content/links/site1/en.html",underTest.sanitize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
  assertEquals("/vanity.html",underTest.map(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
  assertEquals("https://example.org/vanity.html",underTest.externalize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
}
