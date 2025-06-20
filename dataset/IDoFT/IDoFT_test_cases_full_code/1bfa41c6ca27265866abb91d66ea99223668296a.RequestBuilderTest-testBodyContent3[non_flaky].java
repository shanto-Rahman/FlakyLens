/** 
 * Test bodyContent() with a multiple inputs (JSON input should win).
 * @throws IOException
 * @throws JSONException
 */
@Test public void testBodyContent3() throws IOException, JSONException {
  Truck truck=new Truck.Builder().vehicleType("Truck").make("Ford").engineType("raptor").build();
  final Request request=RequestBuilder.post(HttpUrl.parse(urlWithQuery)).bodyContent("application/json",truck,"BAD JSON PATCH BODY","BAD INPUTSTREAM REQUEST BODY").build();
  final RequestBody requestedBody=request.body();
  final Buffer buffer=new Buffer();
  requestedBody.writeTo(buffer);
  try {
    JSONAssert.assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(truck),buffer.readUtf8(),false);
  }
 catch (  JSONException e) {
    throw e;
  }
  assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}
