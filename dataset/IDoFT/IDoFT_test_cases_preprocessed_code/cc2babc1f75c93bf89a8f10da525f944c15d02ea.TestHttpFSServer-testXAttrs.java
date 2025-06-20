/** 
 * Validate XAttr get/set/remove calls.
 */
@Test @TestDir @TestJetty @TestHdfs public void testXAttrs() throws Exception {
Assert.assertEquals(0,xAttrs.size());
Assert.assertEquals(2,xAttrs.size());
Assert.assertArrayEquals(value1,xAttrs.get(name1));
Assert.assertArrayEquals(value2,xAttrs.get(name2));
Assert.assertEquals(1,xAttrs.size());
Assert.assertArrayEquals(value2,xAttrs.get(name2));
Assert.assertEquals(0,xAttrs.size());
}