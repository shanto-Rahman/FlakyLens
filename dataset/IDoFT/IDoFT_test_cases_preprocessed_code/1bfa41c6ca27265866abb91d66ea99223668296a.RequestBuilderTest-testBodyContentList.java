/** 
 * Test with list of models.
 * @throws IOException Signals that an I/O exception has occurred.
 */
@Test public void testBodyContentList() throws IOException {
assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(listOfModels),buffer.readUtf8());
assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}