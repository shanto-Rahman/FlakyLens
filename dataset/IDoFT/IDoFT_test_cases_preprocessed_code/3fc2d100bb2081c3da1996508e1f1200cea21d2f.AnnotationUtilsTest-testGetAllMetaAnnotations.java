@Test public void testGetAllMetaAnnotations(){
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
assertEquals(2,metaAnnotations.size());
assertEquals(Inherited.class,metaAnnotations.get(offset++).annotationType());
assertEquals(Adaptive.class,metaAnnotations.get(offset++).annotationType());
}