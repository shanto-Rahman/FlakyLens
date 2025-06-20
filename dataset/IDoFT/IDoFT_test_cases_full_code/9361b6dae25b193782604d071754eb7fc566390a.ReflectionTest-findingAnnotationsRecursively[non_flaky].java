@Test public void findingAnnotationsRecursively(){
  Method method=findMethod(this.getClass(),"withMarker",String.class);
  List<Annotation> annotations=allAnnotations(method.getParameters()[0]);
  assertEquals(4,annotations.size());
  assertEquals(X.class,annotations.get(0).annotationType());
  assertEquals(Y.class,annotations.get(1).annotationType());
  assertTrue(Z.class.equals(annotations.get(2).annotationType()) || W.class.equals(annotations.get(2).annotationType()));
  if (Z.class.equals(annotations.get(2).annotationType())) {
    assertEquals(W.class,annotations.get(3).annotationType());
  }
 else {
    assertEquals(Z.class,annotations.get(3).annotationType());
  }
}
