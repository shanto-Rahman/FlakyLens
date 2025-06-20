@Test public void checkTemplateNegociationText(TestContext context){
context.assertEquals(200,r.statusCode());
context.assertEquals("## my title ##\n" + "\n" + "my message",r.body());
context.assertEquals("text/plain",r.getHeader("Content-Type"));
webClient.get("/nego").putHeader("Accept","text/plain").as(BodyCodec.string()).rxSend().map(r -> {
  context.assertEquals(200,r.statusCode());
  context.assertEquals("## my title ##\n" + "\n" + "my message",r.body());
  context.assertEquals("text/plain",r.getHeader("Content-Type"));
  return r;
}
).doOnError(x -> context.fail(x)).subscribe(response -> {
  async.complete();
}
);
}