@Test public void testRoute_requestWithTag_shouldDowngrade(){
Assert.assertTrue(filteredInvokers.contains(defaultInvoker));
Assert.assertFalse(filteredInvokers.contains(yellowInvoker));
Assert.assertFalse(filteredInvokers.contains(blueInvoker));
Assert.assertFalse(filteredInvokers.contains(redInvoker));
}