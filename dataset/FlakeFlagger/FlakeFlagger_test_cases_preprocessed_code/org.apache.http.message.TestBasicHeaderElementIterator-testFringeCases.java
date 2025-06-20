@Test public void testFringeCases(){
Assert.assertFalse(hei.hasNext());
Assert.fail("NoSuchElementException should have been thrown");
Assert.assertFalse(hei.hasNext());
Assert.fail("NoSuchElementException should have been thrown");
}