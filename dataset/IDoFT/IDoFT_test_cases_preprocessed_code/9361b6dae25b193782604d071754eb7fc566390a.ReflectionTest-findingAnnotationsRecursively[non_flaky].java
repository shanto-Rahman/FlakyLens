@Test public void findingAnnotationsRecursively(){
assertEquals(4,annotations.size());
assertEquals(X.class,annotations.get(0).annotationType());
assertEquals(Y.class,annotations.get(1).annotationType());
assertTrue(Z.class.equals(annotations.get(2).annotationType()) || W.class.equals(annotations.get(2).annotationType()));
if (Z.class.equals(annotations.get(2).annotationType())) {
assertEquals(W.class,annotations.get(3).annotationType());
assertEquals(Z.class,annotations.get(3).annotationType());
}
}