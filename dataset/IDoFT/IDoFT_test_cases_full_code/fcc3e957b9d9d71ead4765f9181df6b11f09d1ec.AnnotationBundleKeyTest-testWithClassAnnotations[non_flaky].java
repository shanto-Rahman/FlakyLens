public void testWithClassAnnotations() throws Exception {
  Annotation[] annotation1=Helper.class.getAnnotations();
  Annotation[] annotation2=Helper.class.getAnnotations();
  Arrays.sort(annotation1,(i,j) -> i.toString().compareTo(j.toString()));
  Arrays.sort(annotation2,(i,j) -> i.toString().compareTo(j.toString()));
  _checkWith(annotation1,annotation2);
}
