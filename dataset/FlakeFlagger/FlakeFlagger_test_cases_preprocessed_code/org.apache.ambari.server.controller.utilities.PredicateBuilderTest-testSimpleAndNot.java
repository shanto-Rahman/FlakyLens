@Test public void testSimpleAndNot(){
Assert.assertFalse(predicate1.evaluate(resource));
Assert.assertTrue(predicate2.evaluate(resource));
}