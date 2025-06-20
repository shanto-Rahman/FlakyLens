@Test public void testGetAllMetaAnnotations(){
  List<Annotation> metaAnnotations=getAllMetaAnnotations(Service5.class);
  int offset=0;
  HashSet<Object> set1=new HashSet<>();
  metaAnnotations.forEach(t -> set1.add(t.annotationType()));
  HashSet<Object> set2=new HashSet<>();
  set2.add(Inherited.class);
  set2.add(DubboService.class);
  set2.add(Service4.class);
  set2.add(Service3.class);
  set2.add(Service2.class);
  assertEquals(9,metaAnnotations.size());
  assertEquals(set1,set2);
  metaAnnotations=getAllMetaAnnotations(MyAdaptive.class);
  HashSet<Object> set3=new HashSet<>();
  metaAnnotations.forEach(t -> set3.add(t.annotationType()));
  HashSet<Object> set4=new HashSet<>();
  metaAnnotations.forEach(t -> set3.add(t.annotationType()));
  set4.add(Inherited.class);
  set4.add(Adaptive.class);
  assertEquals(2,metaAnnotations.size());
  assertEquals(set3,set4);
}
