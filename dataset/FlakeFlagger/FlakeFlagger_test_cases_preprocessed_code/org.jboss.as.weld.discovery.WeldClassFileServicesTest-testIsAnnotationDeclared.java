@Test public void testIsAnnotationDeclared(){
Assert.assertTrue(alpha.isAnnotationDeclared(Vetoed.class));//RW
Assert.assertTrue(innerInterface.isAnnotationDeclared(Named.class));//RW
Assert.assertFalse(bravo.isAnnotationDeclared(Vetoed.class));//RW
Assert.assertFalse(bravo.isAnnotationDeclared(Named.class));//RW
Assert.assertFalse(bravo.isAnnotationDeclared(Inject.class));//RW
}