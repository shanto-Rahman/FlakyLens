@Test void testVanityConfig(){
  Page page=context.create().page("/content/links/site1/en","/conf/example",ImmutableMap.of("sling:vanityPath","vanity.html"));
  DefaultPathProcessor underTest=context.registerInjectActivateService(new DefaultPathProcessor(),ImmutableMap.of("vanityConfig","shouldBeDefault"));
  assertEquals("/content/site1/en.html",underTest.map(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
  assertEquals("https://example.org/content/links/site1/en.html",underTest.externalize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
  context.request().setContextPath("/cp");
  underTest=context.registerInjectActivateService(new DefaultPathProcessor(),ImmutableMap.of("vanityConfig",DefaultPathProcessor.VanityConfig.ALWAYS.getValue()));
  assertEquals("/cp/vanity.html",underTest.sanitize(page.getPath() + LinkHandler.HTML_EXTENSION,context.request()));
}
