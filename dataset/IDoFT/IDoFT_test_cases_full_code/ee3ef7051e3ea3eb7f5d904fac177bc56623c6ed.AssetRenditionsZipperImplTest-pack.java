@Test public void pack() throws IOException, ServletException {
  final byte[] expectedOutputStream=IOUtils.toByteArray(this.getClass().getResourceAsStream("AssetRenditionsZipperImplTest__original.png"));
  doAnswer(invocation -> {
    Object[] args=invocation.getArguments();
    ((AssetRenditionDownloadResponse)args[1]).getOutputStream().write(expectedOutputStream);
    return null;
  }
).when(requestDispatcher).include(any(SlingHttpServletRequest.class),any(SlingHttpServletResponse.class));
  ctx.registerInjectActivateService(new AssetRenditionsZipperImpl());
  AssetRenditionsZipperImpl zipper=(AssetRenditionsZipperImpl)ctx.getService(AssetRenditionsDownloadOrchestrator.class);
  ctx.currentResource("/content/default");
  AssetModel asset=modelFactory.getModelFromWrappedRequest(ctx.request(),ctx.resourceResolver().getResource("/content/dam/test.png"),AssetModel.class);
  zipper.execute(ctx.request(),ctx.response(),Arrays.asList(asset),Arrays.asList("test"));
  assertEquals("application/zip",ctx.response().getContentType());
  assertEquals(334,ctx.response().getOutput().length);
}
