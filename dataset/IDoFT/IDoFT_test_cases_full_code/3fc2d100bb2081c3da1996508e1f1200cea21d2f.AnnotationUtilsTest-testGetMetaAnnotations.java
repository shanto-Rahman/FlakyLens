@Test public void testGetMetaAnnotations(){
  List<Annotation> metaAnnotations=getMetaAnnotations(Service.class,a -> isSameType(a,Inherited.class));
  assertEquals(1,metaAnnotations.size());
  assertEquals(Inherited.class,metaAnnotations.get(0).annotationType());
  metaAnnotations=getMetaAnnotations(Service.class);
  assertEquals(2,metaAnnotations.size());
  assertEquals(Inherited.class,metaAnnotations.get(0).annotationType());
  assertEquals(Deprecated.class,metaAnnotations.get(1).annotationType());
}
