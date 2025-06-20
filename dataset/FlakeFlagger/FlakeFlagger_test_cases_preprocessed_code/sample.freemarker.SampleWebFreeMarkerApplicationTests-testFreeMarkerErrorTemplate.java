@Test public void testFreeMarkerErrorTemplate() throws Exception {
assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
assertTrue("Wrong body:\n" + responseEntity.getBody(),responseEntity.getBody().contains("Something went wrong: 404 Not Found"));
}