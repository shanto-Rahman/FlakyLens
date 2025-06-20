/** 
 * Test bodyContent() with a model instance.
 * @throws IOException
 */
@Test public void testBodyContent1() throws IOException {
assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(truck),buffer.readUtf8());
assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}