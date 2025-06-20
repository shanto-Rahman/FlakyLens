@Test public void testGreaterThanEqualToLong(){
Assert.assertTrue(predicate1.evaluate(resource));
Assert.assertFalse(predicate2.evaluate(resource));
}