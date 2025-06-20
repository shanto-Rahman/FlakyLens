/** 
 * Test bodyContent() with a model instance.
 * @throws IOException
 * @throws JSONException
 */
@Test public void testBodyContent1() throws IOException, JSONException {
JSONAssert.assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(truck),buffer.readUtf8(),false);
assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}