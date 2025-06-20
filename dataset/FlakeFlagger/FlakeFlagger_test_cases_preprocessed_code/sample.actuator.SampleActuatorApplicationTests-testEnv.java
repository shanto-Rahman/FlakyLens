@Test public void testEnv() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body: " + body,body.containsKey("systemProperties"));
}