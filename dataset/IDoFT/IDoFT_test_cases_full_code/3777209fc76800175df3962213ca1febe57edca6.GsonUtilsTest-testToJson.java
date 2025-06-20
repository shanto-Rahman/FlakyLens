/** 
 * test method about  {@link GsonUtils#toJson(java.lang.Object)}.
 */
@Test public void testToJson(){
  TestObject testObject=generateTestObject();
  Assert.assertEquals(EXPECTED_JSON,GsonUtils.getInstance().toJson(testObject));
}
