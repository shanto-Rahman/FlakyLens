/** 
 * test method about  {@link GsonUtils#toJson(java.lang.Object)}.
 */
@Test public void testToJson(){
  TestObject testObject=generateTestObject();
  JsonParser parser=new JsonParser();
  JsonElement expectedJson=parser.parse(EXPECTED_JSON);
  JsonElement objectJson=parser.parse(GsonUtils.getInstance().toJson(testObject));
  assertEquals(expectedJson,objectJson);
}
