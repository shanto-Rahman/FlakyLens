@Test public void checkSwagger(TestContext context){
context.assertEquals(200,r.statusCode());
context.assertNotNull(swaggerDef);
context.assertEquals("2.0",swaggerDef.getString("swagger"));
context.assertNotNull(info);
context.assertEquals("1.0",info.getString("version"));
context.assertNotNull(paths);
context.assertTrue(paths.size() > 0);
context.assertNotNull(swaggerDef.getString("host"));
context.assertNotNull(definitions);
context.assertTrue(definitions.size() == 1,"There should only be one definition. No Observable / Single / etc.");
context.assertNotNull(dogDef);
context.assertEquals("object",dogDef.getString("type"));
}