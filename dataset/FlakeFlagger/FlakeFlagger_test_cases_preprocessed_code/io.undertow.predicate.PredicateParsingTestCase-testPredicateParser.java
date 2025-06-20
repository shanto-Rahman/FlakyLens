@Test public void testPredicateParser(){
Assert.assertTrue(predicate instanceof PathMatchPredicate);
Assert.assertTrue(predicate.resolve(e));
Assert.assertFalse(predicate.resolve(e));
Assert.assertFalse(predicate.resolve(e));
Assert.assertTrue(predicate.resolve(e));
}