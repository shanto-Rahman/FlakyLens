@Test public void testSimpleNot(){
Assert.assertFalse(predicate1.evaluate(resource));
Assert.assertTrue(predicate2.evaluate(resource));
}