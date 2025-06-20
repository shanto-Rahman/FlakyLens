/** 
 * test method about  {@link GsonUtils#toJson(java.lang.Object)}.
 */
@Test public void testToJson(){
Assert.assertEquals(EXPECTED_JSON,GsonUtils.getInstance().toJson(testObject));
}