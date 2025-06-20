@Test public void testRemove2(){
Assert.assertTrue(byVersion5.size() == 2);
Assert.assertEquals(byVersion5.get(key4),value4);
Assert.assertEquals(byVersion5.get(key5),value5);
Assert.assertTrue(byVersion1.size() == 1);
Assert.assertEquals(byVersion1.get(key1),value1);
Assert.assertTrue(byVersion4.size() == 2);
Assert.assertEquals(byVersion4.get(key1),value1);
Assert.assertEquals(byVersion4.get(key4),value4);
Assert.assertEquals(old1,value1);
Assert.assertTrue(byVersion5.size() == 2);
Assert.assertEquals(byVersion5.get(key4),value4);
Assert.assertEquals(byVersion5.get(key5),value5);
Assert.assertNull(byVersion1);
Assert.assertTrue(byVersion4.size() == 1);
Assert.assertEquals(byVersion4.get(key4),value4);
}