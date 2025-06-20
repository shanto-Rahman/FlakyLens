@Test public void testMultiHeader(){
Assert.assertTrue(hei.hasNext());
Assert.assertEquals("The two header values must be equal","value0",elem.getName());
Assert.assertTrue(hei.hasNext());
Assert.assertEquals("The two header values must be equal","value1",elem.getName());
Assert.assertFalse(hei.hasNext());
Assert.fail("NoSuchElementException should have been thrown");
Assert.assertFalse(hei.hasNext());
Assert.fail("NoSuchElementException should have been thrown");
}