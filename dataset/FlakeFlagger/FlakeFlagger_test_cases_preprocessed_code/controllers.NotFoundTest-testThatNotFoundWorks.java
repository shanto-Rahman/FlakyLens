@Test public void testThatNotFoundWorks(){
assertEquals(404,httpResponse.getStatusLine().getStatusCode());
assertTrue(content.contains("Oops. Not found."));
}