@Test public void testGreaterThanEqualToInteger(){
Assert.assertTrue(predicate1.evaluate(resource));
Assert.assertFalse(predicate2.evaluate(resource));
}