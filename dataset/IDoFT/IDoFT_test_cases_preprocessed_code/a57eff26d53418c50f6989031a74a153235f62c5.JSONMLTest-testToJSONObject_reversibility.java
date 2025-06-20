/** 
 * JSON string cannot be reverted to original xml. See test result in comment below.
 */
@Test public void testToJSONObject_reversibility(){
assertTrue("JSON Objects are not similar",originalObject.similar(revertedObject));
assertEquals("original JSON does not equal the new JSON",originalJson,newJson);
}