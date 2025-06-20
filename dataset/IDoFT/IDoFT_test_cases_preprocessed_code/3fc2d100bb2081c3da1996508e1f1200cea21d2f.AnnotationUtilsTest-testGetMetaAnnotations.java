@Test public void testGetMetaAnnotations(){
assertEquals(1,metaAnnotations.size());
assertEquals(Inherited.class,metaAnnotations.get(0).annotationType());
assertEquals(2,metaAnnotations.size());
assertEquals(Inherited.class,metaAnnotations.get(0).annotationType());
assertEquals(Deprecated.class,metaAnnotations.get(1).annotationType());
}