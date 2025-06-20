/** 
 * Fruits - serialization tests for simple property on sub-classes
 */
public void testExistingPropertySerializationFruits() throws Exception {
assertEquals(3,result.size());
assertEquals(pinguo.name,result.get("name"));
assertEquals(pinguo.seedCount,result.get("seedCount"));
assertEquals(pinguo.type,result.get("type"));
assertEquals(3,result.size());
assertEquals(mandarin.name,result.get("name"));
assertEquals(mandarin.color,result.get("color"));
assertEquals(mandarin.type,result.get("type"));
assertEquals(pinguoSerialized,pinguoJson);
assertEquals(mandarinSerialized,mandarinJson);
assertEquals(fruitWrapperSerialized,pinguoWrapperJson);
assertEquals(fruitListSerialized,fruitListJson);
}