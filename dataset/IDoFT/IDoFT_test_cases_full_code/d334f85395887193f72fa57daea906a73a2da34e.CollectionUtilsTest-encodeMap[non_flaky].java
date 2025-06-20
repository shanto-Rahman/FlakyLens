/** 
 * Encode map.
 */
@Test public void encodeMap(){
  Map<String,String> map=null;
  Assertions.assertNull(CollectionUtils.encodeMap(map));
  map=new LinkedHashMap<>();
  Assertions.assertEquals("",CollectionUtils.encodeMap(map));
  map.put("x","1");
  Assertions.assertEquals("x=1",CollectionUtils.encodeMap(map));
  map.put("y","2");
  Assertions.assertEquals("x=1&y=2",CollectionUtils.encodeMap(map));
}
