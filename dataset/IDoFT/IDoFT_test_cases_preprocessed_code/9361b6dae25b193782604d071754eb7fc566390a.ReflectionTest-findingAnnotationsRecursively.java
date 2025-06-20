@Test public void findingAnnotationsRecursively(){
assertEquals(4,annotations.size());
assertEquals(X.class,annotations.get(0).annotationType());
assertEquals(Y.class,annotations.get(1).annotationType());
assertEquals(Z.class,annotations.get(2).annotationType());
assertEquals(W.class,annotations.get(3).annotationType());
}