@Test public void testGetMetaAnnotations(){
  List<Annotation> metaAnnotations=getMetaAnnotations(Service.class,a -> isSameType(a,Inherited.class));
  assertEquals(1,metaAnnotations.size());
  assertEquals(Inherited.class,metaAnnotations.get(0).annotationType());
  metaAnnotations=getMetaAnnotations(Service.class);
  HashSet<Object> set1=new HashSet<>();
  metaAnnotations.forEach(t -> set1.add(t.annotationType()));
  HashSet<Object> set2=new HashSet<>();
  set2.add(Inherited.class);
  set2.add(Deprecated.class);
  assertEquals(2,metaAnnotations.size());
  assertEquals(set1,set2);
}
