@Test public void testGetAllDeclaredAnnotations(){
  List<Annotation> annotations=getAllDeclaredAnnotations(A.class);
  assertADeclaredAnnotations(annotations,0);
  annotations=getAllDeclaredAnnotations(B.class);
  assertTrue(isSameType(annotations.get(0),Service5.class));
  assertADeclaredAnnotations(annotations,1);
  annotations=new LinkedList<>(getAllDeclaredAnnotations(C.class));
  assertTrue(isSameType(annotations.get(0),MyAdaptive.class));
  assertTrue(isSameType(annotations.get(1),Service5.class));
  assertADeclaredAnnotations(annotations,2);
  annotations=getAllDeclaredAnnotations(findMethod(A.class,"execute"));
  MyAdaptive myAdaptive=(MyAdaptive)annotations.get(0);
  assertArrayEquals(new String[]{"e"},myAdaptive.value());
  annotations=getAllDeclaredAnnotations(findMethod(B.class,"execute"));
  Adaptive adaptive=(Adaptive)annotations.get(0);
  assertArrayEquals(new String[]{"f"},adaptive.value());
}
