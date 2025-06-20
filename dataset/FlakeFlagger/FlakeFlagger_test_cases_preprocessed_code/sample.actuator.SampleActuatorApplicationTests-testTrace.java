@Test public void testTrace() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals("200",map.get("status"));
}