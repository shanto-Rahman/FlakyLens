@Test public void testBadAltusErrors() throws Exception {
fail();
assertEquals(1,client.apiCalls);
assertEquals(500,e.getHttpCode());
assertEquals("500: null",e.getMessage());
fail();
assertEquals(1,client.apiCalls);
assertEquals(500,e.getHttpCode());
assertEquals("500: NOT JSON!",e.getMessage());
fail();
assertEquals(1,client.apiCalls);
assertEquals(500,e.getHttpCode());
assertEquals("500: {}",e.getMessage());
fail();
assertEquals(1,client.apiCalls);
assertEquals(500,e.getHttpCode());
assertEquals("500: " + MAPPER.writeValueAsString(error),e.getMessage());
fail();
assertEquals(1,client.apiCalls);
assertEquals(500,e.getHttpCode());
assertEquals("500: " + MAPPER.writeValueAsString(error),e.getMessage());
fail();
assertEquals(1,client.apiCalls);
assertEquals(500,e.getHttpCode());
assertEquals("500: " + MAPPER.writeValueAsString(error),e.getMessage());
}