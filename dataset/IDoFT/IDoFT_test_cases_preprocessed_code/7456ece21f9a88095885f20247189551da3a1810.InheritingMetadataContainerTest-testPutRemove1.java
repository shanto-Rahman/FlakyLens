@Test public void testPutRemove1(){
Assert.assertTrue(byVersion1.size() == 1);
Assert.assertEquals(byVersion1.get(key1),value1);
Assert.assertTrue(byVersion4.size() == 2);
Assert.assertEquals(byVersion4.get(key1),value1);
Assert.assertEquals(byVersion4.get(key4),value4);
Assert.assertTrue(byVersion7.size() == 2);
Assert.assertEquals(byVersion7.get(key1),value1);
Assert.assertEquals(byVersion7.get(key7),value7);
Assert.assertTrue(byVersion1.size() == 1);
Assert.assertEquals(byVersion1.get(key1),value1);
Assert.assertTrue(byVersion4.size() == 1);
Assert.assertEquals(byVersion4.get(key1),value1);
Assert.assertTrue(byVersion7.size() == 2);
Assert.assertEquals(byVersion7.get(key1),value1);
Assert.assertEquals(byVersion7.get(key7),value7);
}