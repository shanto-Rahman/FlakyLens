@Test public void testBlocks(){
Assert.assertTrue(predicate1.evaluate(resource));
Assert.assertTrue(predicate2.evaluate(resource));
Assert.assertTrue(predicate3.evaluate(resource));
Assert.assertFalse(predicate4.evaluate(resource));
Assert.assertTrue(predicate5.evaluate(resource));
Assert.assertTrue(predicate6.evaluate(resource));
Assert.assertFalse(predicate7.evaluate(resource));
Assert.assertFalse(predicate8.evaluate(resource));
Assert.assertFalse(predicate9.evaluate(resource));
Assert.assertTrue(predicate10.evaluate(resource));
}