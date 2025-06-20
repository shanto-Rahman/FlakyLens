/** 
 * Test bodyContent() with a model instance.
 * @throws IOException
 * @throws JSONException
 */
@Test public void testBodyContent1() throws IOException, JSONException {
  Truck truck=new Truck.Builder().vehicleType("Truck").make("Ford").engineType("raptor").build();
  final Request request=RequestBuilder.post(HttpUrl.parse(urlWithQuery)).bodyContent("application/json",truck,null,(InputStream)null).build();
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
