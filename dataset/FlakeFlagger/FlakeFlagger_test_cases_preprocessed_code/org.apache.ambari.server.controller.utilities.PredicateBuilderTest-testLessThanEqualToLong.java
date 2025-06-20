@Test public void testLessThanEqualToLong(){
Assert.assertTrue(predicate1.evaluate(resource));
Assert.assertFalse(predicate2.evaluate(resource));
}