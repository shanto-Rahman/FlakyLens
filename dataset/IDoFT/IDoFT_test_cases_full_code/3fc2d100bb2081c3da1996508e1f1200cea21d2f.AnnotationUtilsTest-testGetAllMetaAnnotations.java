@Test public void testGetAllMetaAnnotations(){
  List<Annotation> metaAnnotations=getAllMetaAnnotations(Service5.class);
  int offset=0;
  assertEquals(9,metaAnnotations.size());
  assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Service4.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Service3.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Service2.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(DubboService.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
  metaAnnotations=getAllMetaAnnotations(MyAdaptive.class);
  offset=0;
  assertEquals(2,metaAnnotations.size());
  assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
  assertEquals(Adaptive.class,metaAnnotations.get(offset++).annotationType());
}
