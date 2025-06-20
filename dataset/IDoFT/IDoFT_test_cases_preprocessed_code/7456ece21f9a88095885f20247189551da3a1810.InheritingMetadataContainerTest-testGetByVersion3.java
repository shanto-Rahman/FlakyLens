@Test public void testGetByVersion3(){
Assert.assertTrue(byVersion.size() == 1);
Assert.assertEquals(byVersion.get(key4),value4);
}