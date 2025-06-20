@Test public void testBeans() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals(1,entity.getBody().size());
assertTrue("Wrong body: " + body,((String)body.get("context")).startsWith("application"));
}