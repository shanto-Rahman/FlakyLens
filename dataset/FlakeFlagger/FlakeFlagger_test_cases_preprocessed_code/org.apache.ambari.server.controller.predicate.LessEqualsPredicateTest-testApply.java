@Test public void testApply(){
Assert.assertTrue(predicate.evaluate(resource));
Assert.assertFalse(predicate.evaluate(resource));
Assert.assertTrue(predicate.evaluate(resource));
}