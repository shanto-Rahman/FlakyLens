@Test public void shouldWriteToElasticPort(TestContext context) throws IOException {
  Async async=context.async();
  vertx.createHttpServer().requestHandler(request -> {
    request.bodyHandler(body -> {
      context.assertTrue(body.toString() != null);
      async.complete();
    }
);
  }
).listen(Configuration.getElasticPort());
  ExcelParser fileParser=new ExcelParser();
  fileParser.setFileData(getClass().getResource(TestParser.TEST_XLS_FILE).getPath(),TestParser.ROW_OFFSET,"testFileName.xls");
  vertx.eventBus().send(Configuration.INDEXING_ELASTICSEARCH,new ImportEvent().setParser(fileParser).setIndex("text-index").setClearExisting(false).setMapping("test-mapping"));
}
