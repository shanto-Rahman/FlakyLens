@Test public void checkSwagger(TestContext context){
  Async async=context.async();
  webClient.get("/swagger.json").as(BodyCodec.jsonObject()).rxSend().map(r -> {
    context.assertEquals(200,r.statusCode());
    JsonObject swaggerDef=r.body();
    context.assertNotNull(swaggerDef);
    context.assertEquals("2.0",swaggerDef.getString("swagger"));
    JsonObject info=swaggerDef.getJsonObject("info");
    context.assertNotNull(info);
    context.assertEquals("1.0",info.getString("version"));
    JsonObject paths=swaggerDef.getJsonObject("paths");
    context.assertNotNull(paths);
    context.assertTrue(paths.size() > 0);
    context.assertNotNull(swaggerDef.getString("host"));
    JsonObject definitions=swaggerDef.getJsonObject("definitions");
    context.assertNotNull(definitions);
    context.assertTrue(definitions.size() == 1,"There should only be one definition. No Observable / Single / etc.");
    JsonObject dogDef=definitions.getJsonObject("Dog");
    context.assertNotNull(dogDef);
    context.assertEquals("object",dogDef.getString("type"));
    return r;
  }
).subscribe(response -> async.complete());
}
