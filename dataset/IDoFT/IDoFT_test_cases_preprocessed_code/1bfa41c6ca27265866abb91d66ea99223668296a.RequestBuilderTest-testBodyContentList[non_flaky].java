/** 
 * Test with list of models.
 * @throws IOException Signals that an I/O exception has occurred.
 * @throws JSONException Signals that a JSON parsing error has occured.
 */
@Test public void testBodyContentList() throws IOException, JSONException {
JSONAssert.assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(listOfModels),buffer.readUtf8(),false);
assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}