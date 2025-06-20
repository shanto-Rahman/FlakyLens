/** 
 * Test bodyContent() with a multiple inputs (JSON input should win).
 * @throws IOException
 */
@Test public void testBodyContent3() throws IOException {
assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(truck),buffer.readUtf8());
assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}