/** 
 * Test bodyContent() with a multiple inputs (JSON input should win).
 * @throws IOException
 * @throws JSONException
 */
@Test public void testBodyContent3() throws IOException, JSONException {
JSONAssert.assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(truck),buffer.readUtf8(),false);
assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}