/** 
 * ArrayMerger test
 * @throws Exception
 */
@Test public void testArrayMerger() throws Exception {
Assert.assertTrue(result.getClass().isArray());
Assert.assertEquals(6,Array.getLength(result));
Assert.assertTrue(String.class.isInstance(Array.get(result,0)));
Assert.assertEquals(String.valueOf(i + 1),Array.get(result,i));
Assert.assertTrue(result.getClass().isArray());
Assert.assertEquals(7,Array.getLength(result));
Assert.assertTrue(int.class == result.getClass().getComponentType());
Assert.assertEquals(i + 1,Array.get(result,i));
}