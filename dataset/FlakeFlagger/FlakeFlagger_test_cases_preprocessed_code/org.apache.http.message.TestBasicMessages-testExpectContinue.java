@Test public void testExpectContinue(){
Assert.assertFalse(request.expectContinue());
Assert.assertFalse(request.expectContinue());
Assert.assertTrue(request.expectContinue());
}