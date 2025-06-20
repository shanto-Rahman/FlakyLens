@Test public void testAnnotatedClass(){
Assert.assertEquals(new HashSet<>(Arrays.asList(expeccted)),AnnotationServletContainerInitializer.HANDLES_TYPES);
}