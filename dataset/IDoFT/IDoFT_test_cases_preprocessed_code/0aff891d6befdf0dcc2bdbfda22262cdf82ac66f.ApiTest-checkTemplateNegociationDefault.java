@Test public void checkTemplateNegociationDefault(TestContext context){
context.assertEquals(200,r.statusCode());
context.assertEquals("<html>\n" + " <head>\n" + "  <title>my title</title>\n"+ " </head>\n"+ " <body>my message</body>\n"+ "</html>",r.body());
context.assertEquals("text/html",r.getHeader("Content-Type"));
webClient.get("/nego").as(BodyCodec.string()).rxSend().map(r -> {
  context.assertEquals(200,r.statusCode());
  context.assertEquals("<html>\n" + " <head>\n" + "  <title>my title</title>\n"+ " </head>\n"+ " <body>my message</body>\n"+ "</html>",r.body());
  context.assertEquals("text/html",r.getHeader("Content-Type"));
  return r;
}
).doOnError(x -> context.fail(x)).subscribe(response -> {
  async.complete();
}
);
}