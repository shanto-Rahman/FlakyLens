@Test public void testAddField2() throws IOException, InterruptedException, InitializationException {
  final Map<String,Object> config=Collections.emptyMap();
  final JsonBuilderFactory factory=Json.createBuilderFactory(config);
  final JsonObjectBuilder builder=factory.createObjectBuilder();
  Map<String,String> values=new HashMap<String,String>();
  values.put("TestKeyString1","StringValue1");
  values.put("TestKeyString2","StringValue2");
  AzureLogAnalyticsProvenanceReportingTask.addField(builder,factory,"TestKeyString",values,true);
  javax.json.JsonObject actualJson=builder.build();
  String expectedjsonString="{\"TestKeyString\":{\"TestKeyString2\":\"StringValue2\",\"TestKeyString1\":\"StringValue1\"}}";
  JsonObject expectedJson=new Gson().fromJson(expectedjsonString,JsonObject.class);
  assertEquals(expectedJson.toString(),actualJson.toString());
}
