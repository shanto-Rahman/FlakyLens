@Test public void testSimpleErrorPageIsGenerated() throws IOException {
Assert.assertEquals(404,result.getStatusLine().getStatusCode());
Assert.assertTrue(response,response.contains(StatusCodes.NOT_FOUND_STRING));
}