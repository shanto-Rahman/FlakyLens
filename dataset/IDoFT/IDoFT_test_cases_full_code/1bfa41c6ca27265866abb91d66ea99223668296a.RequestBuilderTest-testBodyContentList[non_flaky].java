/** 
 * Test with list of models.
 * @throws IOException Signals that an I/O exception has occurred.
 * @throws JSONException Signals that a JSON parsing error has occured.
 */
@Test public void testBodyContentList() throws IOException, JSONException {
  final List<Vehicle> listOfModels=new ArrayList<>();
  listOfModels.add(new Truck.Builder().vehicleType("Truck").make("Ford").engineType("raptor").build());
  listOfModels.add(new Car.Builder().vehicleType("Car").make("Ford").bodyStyle("mach-e").build());
  final Request request=RequestBuilder.post(HttpUrl.parse(urlWithQuery)).bodyContent("application/json",listOfModels,null,(InputStream)null).build();
  final RequestBody requestedBody=request.body();
  final Buffer buffer=new Buffer();
  requestedBody.writeTo(buffer);
  try {
    JSONAssert.assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(listOfModels),buffer.readUtf8(),false);
  }
 catch (  JSONException e) {
    throw e;
  }
  assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}
