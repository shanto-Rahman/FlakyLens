@Test public void testErrorPageDirectAccess() throws Exception {
assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,entity.getStatusCode());
assertEquals("None",body.get("error"));
assertEquals(999,body.get("status"));
}