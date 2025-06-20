@Test public void testAndOr(){
Assert.assertTrue(predicate1.evaluate(resource));
Assert.assertTrue(predicate2.evaluate(resource));
Assert.assertTrue(predicate3.evaluate(resource));
Assert.assertFalse(predicate4.evaluate(resource));
}