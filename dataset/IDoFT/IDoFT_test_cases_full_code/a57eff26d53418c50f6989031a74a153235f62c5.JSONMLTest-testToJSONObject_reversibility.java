/** 
 * JSON string cannot be reverted to original xml. See test result in comment below.
 */
@Test public void testToJSONObject_reversibility(){
  final String originalXml="<readResult><errors someAttr=\"arrtValue\"><code>400</code></errors><errors><code>402</code></errors></readResult>";
  final JSONObject originalObject=JSONML.toJSONObject(originalXml,false);
  final String originalJson=originalObject.toString();
  final String xml=JSONML.toString(originalObject);
  final JSONObject revertedObject=JSONML.toJSONObject(xml,false);
  final String newJson=revertedObject.toString();
  assertTrue("JSON Objects are not similar",originalObject.similar(revertedObject));
  assertEquals("original JSON does not equal the new JSON",originalJson,newJson);
}
