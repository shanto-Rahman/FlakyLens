@Test public void testApply(){
Assert.assertTrue(notPredicate.evaluate(resource));
Assert.assertFalse(notPredicate.evaluate(resource));
}