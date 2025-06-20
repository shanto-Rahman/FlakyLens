/** 
 * Fruits - serialization tests for simple property on sub-classes
 */
public void testExistingPropertySerializationFruits() throws Exception {
  Map<String,Object> result=writeAndMap(MAPPER,pinguo);
  assertEquals(3,result.size());
  assertEquals(pinguo.name,result.get("name"));
  assertEquals(pinguo.seedCount,result.get("seedCount"));
  assertEquals(pinguo.type,result.get("type"));
  result=writeAndMap(MAPPER,mandarin);
  assertEquals(3,result.size());
  assertEquals(mandarin.name,result.get("name"));
  assertEquals(mandarin.color,result.get("color"));
  assertEquals(mandarin.type,result.get("type"));
  String pinguoSerialized=MAPPER.writeValueAsString(pinguo);
  assertEquals(pinguoSerialized,pinguoJson);
  String mandarinSerialized=MAPPER.writeValueAsString(mandarin);
  assertEquals(mandarinSerialized,mandarinJson);
  String fruitWrapperSerialized=MAPPER.writeValueAsString(pinguoWrapper);
  assertEquals(fruitWrapperSerialized,pinguoWrapperJson);
  String fruitListSerialized=MAPPER.writeValueAsString(fruitList);
  assertEquals(fruitListSerialized,fruitListJson);
}
