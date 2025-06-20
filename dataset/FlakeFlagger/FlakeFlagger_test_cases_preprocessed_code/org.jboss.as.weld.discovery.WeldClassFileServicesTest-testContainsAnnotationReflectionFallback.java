@Test public void testContainsAnnotationReflectionFallback(){
Assert.assertTrue(charlie.containsAnnotation(Target.class));//RW
Assert.assertTrue(bravo.containsAnnotation(Target.class));//RW
}