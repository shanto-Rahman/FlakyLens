@Test public void testLongOr(){
Assert.assertTrue(predicate1.evaluate(resource));
Assert.assertTrue(predicate2.evaluate(resource));
Assert.assertFalse(predicate3.evaluate(resource));
}