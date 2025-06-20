@Test public void test() throws Exception {
Assert.assertNotNull(response);
Assert.assertEquals("SwaggerService",swagger.getTags().get(0).getName());
Assert.assertEquals("/demoService/hello",swagger.getPaths().keySet().toArray()[0].toString());
}