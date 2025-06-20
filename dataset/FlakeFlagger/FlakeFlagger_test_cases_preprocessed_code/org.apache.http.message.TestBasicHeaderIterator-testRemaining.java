@Test public void testRemaining(){
Assert.assertTrue(hit.hasNext());
Assert.assertEquals("0",headers[0],hit.next());
Assert.assertTrue(hit.hasNext());
Assert.assertEquals("1",headers[1],hit.next());
Assert.assertTrue(hit.hasNext());
Assert.assertEquals("2",headers[2],hit.next());
Assert.assertTrue(hit.hasNext());
Assert.assertEquals("3",headers[3],hit.next());
Assert.assertFalse(hit.hasNext());
Assert.assertTrue(hit.hasNext());
Assert.fail("remove not detected");
Assert.assertTrue("no next",((BasicHeaderIterator)hit).findNext(-3) < 0);
}