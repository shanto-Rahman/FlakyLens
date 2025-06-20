@Test public void testErrorPage() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals(999,body.get("status"));
}