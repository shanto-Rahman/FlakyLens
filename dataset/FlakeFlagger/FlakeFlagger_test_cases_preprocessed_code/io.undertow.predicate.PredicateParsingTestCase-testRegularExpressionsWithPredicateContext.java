@Test public void testRegularExpressionsWithPredicateContext(){
Assert.assertTrue(predicate.resolve(e));
Assert.assertFalse(predicate.resolve(e));
Assert.assertTrue(predicate.resolve(e));
Assert.assertTrue(predicate.resolve(e));
Assert.assertFalse(predicate.resolve(e));
}