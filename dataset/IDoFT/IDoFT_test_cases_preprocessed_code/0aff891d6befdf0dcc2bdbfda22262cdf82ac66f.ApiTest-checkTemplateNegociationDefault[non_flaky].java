@Test public void checkTemplateNegociationDefault(TestContext context){
context.assertEquals(200,r.statusCode());
context.assertTrue(("<html>\n" + " <head>\n" + "  <title>my title</title>\n"+ " </head>\n"+ " <body>my message</body>\n"+ "</html>").equals(r.body()) || ("## my title ##\n" + "\n" + "my mewssage").equals(r.body()));
context.assertTrue(r.getHeader("Content-Type").equals("text/html") || r.getHeader("Content-Type").equals("text/plain"));
webClient.get("/nego").as(BodyCodec.string()).rxSend().map(r -> {
  context.assertEquals(200,r.statusCode());
  context.assertTrue(("<html>\n" + " <head>\n" + "  <title>my title</title>\n"+ " </head>\n"+ " <body>my message</body>\n"+ "</html>").equals(r.body()) || ("## my title ##\n" + "\n" + "my mewssage").equals(r.body()));
  context.assertTrue(r.getHeader("Content-Type").equals("text/html") || r.getHeader("Content-Type").equals("text/plain"));
  return r;
}
).doOnError(x -> context.fail(x)).subscribe(response -> {
  async.complete();
}
);
}