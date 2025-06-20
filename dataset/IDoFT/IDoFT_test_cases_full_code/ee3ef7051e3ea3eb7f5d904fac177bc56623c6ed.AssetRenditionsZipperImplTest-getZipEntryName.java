@Test public void getZipEntryName(){
  final String expected="test__my-rendition.png";
  ctx.registerInjectActivateService(new AssetRenditionsZipperImpl(),"rendition.filename.expression",AssetRenditionsZipperImpl.VAR_ASSET_NAME + "__" + AssetRenditionsZipperImpl.VAR_RENDITION_NAME+ "."+ AssetRenditionsZipperImpl.VAR_ASSET_EXTENSION);
  AssetRenditionsZipperImpl zipper=(AssetRenditionsZipperImpl)ctx.getService(AssetRenditionsDownloadOrchestrator.class);
  AssetModel asset=modelFactory.getModelFromWrappedRequest(ctx.request(),ctx.resourceResolver().getResource("/content/dam/test.png"),AssetModel.class);
  final String actual=zipper.getZipEntryName("",asset,"my-rendition","image/png",new HashSet<>());
  assertEquals(expected,actual);
}
