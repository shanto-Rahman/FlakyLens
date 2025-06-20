/** 
 * Encode map.
 */
@Test public void encodeMap(){
Assertions.assertNull(CollectionUtils.encodeMap(map));
Assertions.assertEquals("",CollectionUtils.encodeMap(map));
Assertions.assertEquals("x=1",CollectionUtils.encodeMap(map));
Assertions.assertEquals("x=1&y=2",CollectionUtils.encodeMap(map));
}