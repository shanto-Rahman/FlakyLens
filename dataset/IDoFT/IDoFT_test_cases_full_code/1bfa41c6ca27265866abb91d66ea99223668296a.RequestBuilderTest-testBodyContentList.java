/** 
 * Test with list of models.
 * @throws IOException Signals that an I/O exception has occurred.
 */
@Test public void testBodyContentList() throws IOException {
  final List<Vehicle> listOfModels=new ArrayList<>();
  listOfModels.add(new Truck.Builder().vehicleType("Truck").make("Ford").engineType("raptor").build());
  listOfModels.add(new Car.Builder().vehicleType("Car").make("Ford").bodyStyle("mach-e").build());
  final Request request=RequestBuilder.post(HttpUrl.parse(urlWithQuery)).bodyContent("application/json",listOfModels,null,(InputStream)null).build();
  final RequestBody requestedBody=request.body();
  final Buffer buffer=new Buffer();
  requestedBody.writeTo(buffer);
  assertEquals(GsonSingleton.getGsonWithoutPrettyPrinting().toJson(listOfModels),buffer.readUtf8());
  assertEquals(HttpMediaType.JSON,requestedBody.contentType());
}
