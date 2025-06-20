@Test public void checkMail(TestContext context){
context.assertEquals(200,r.statusCode());
context.assertNotNull(mails);
context.assertEquals(1,mails.size());
context.assertEquals("<html>\n" + " <head>\n" + "  <title>my title</title>\n"+ " </head>\n"+ " <body>my message</body>\n"+ "</html>",mails.get(0).text);
context.assertNull(mails.get(0).html);
webClient.get("/mail").as(BodyCodec.string()).rxSend().map(r -> {
  System.err.println("body: " + r.body());
  context.assertEquals(200,r.statusCode());
  MockMailer mailer=(MockMailer)server.getAppGlobals().getMailer();
  System.err.println("using mailer " + System.identityHashCode(mailer));
  List<SentMail> mails=mailer.getMailsSentTo("foo@example.com");
  context.assertNotNull(mails);
  context.assertEquals(1,mails.size());
  context.assertEquals("<html>\n" + " <head>\n" + "  <title>my title</title>\n"+ " </head>\n"+ " <body>my message</body>\n"+ "</html>",mails.get(0).text);
  context.assertNull(mails.get(0).html);
  return r;
}
).doOnError(x -> context.fail(x)).subscribe(response -> {
  async.complete();
}
);
}