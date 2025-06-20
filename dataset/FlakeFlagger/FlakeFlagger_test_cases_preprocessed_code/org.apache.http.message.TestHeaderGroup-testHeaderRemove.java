@Test public void testHeaderRemove(){
Assert.assertNotNull(i);
Assert.assertTrue(i.hasNext());
Assert.assertTrue(i.hasNext());
Assert.assertEquals(2,headergroup.getAllHeaders().length);
Assert.assertTrue(i.hasNext());
Assert.assertEquals(1,headergroup.getAllHeaders().length);
Assert.assertFalse(i.hasNext());
}