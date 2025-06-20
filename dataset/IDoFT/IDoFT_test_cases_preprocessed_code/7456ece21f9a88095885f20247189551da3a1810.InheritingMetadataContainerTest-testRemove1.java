@Test public void testRemove1(){
Assert.assertEquals(old1,value1);
Assert.assertTrue(byVersion5.size() == 1);
Assert.assertEquals(byVersion5.get(key4),value4);
Assert.assertNull(byVersion1);
}