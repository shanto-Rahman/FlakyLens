@Test public void testApply(){
Assert.assertFalse(orPredicate.evaluate(resource));
Assert.assertTrue(orPredicate.evaluate(resource));
}