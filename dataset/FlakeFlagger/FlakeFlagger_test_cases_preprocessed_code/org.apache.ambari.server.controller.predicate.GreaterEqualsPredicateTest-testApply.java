@Test public void testApply(){
Assert.assertFalse(predicate.evaluate(resource));
Assert.assertTrue(predicate.evaluate(resource));
Assert.assertTrue(predicate.evaluate(resource));
}