@Test public void testContainsAnnotation(){
Assert.assertTrue(alpha.containsAnnotation(Vetoed.class));//RW
Assert.assertTrue(innerInterface.containsAnnotation(Named.class));//RW
Assert.assertFalse(bravo.containsAnnotation(Vetoed.class));//RW
Assert.assertFalse(bravo.containsAnnotation(Named.class));//RW
Assert.assertTrue(bravo.containsAnnotation(Inject.class));//RW
}