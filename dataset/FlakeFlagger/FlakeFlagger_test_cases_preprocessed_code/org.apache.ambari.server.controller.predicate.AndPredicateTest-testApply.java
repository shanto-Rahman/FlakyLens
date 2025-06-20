@Test public void testApply(){
Assert.assertFalse(andPredicate.evaluate(resource));
Assert.assertTrue(andPredicate.evaluate(resource));
}