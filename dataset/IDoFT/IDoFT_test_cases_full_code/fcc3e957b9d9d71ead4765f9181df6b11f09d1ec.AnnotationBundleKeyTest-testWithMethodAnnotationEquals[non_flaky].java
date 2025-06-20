public void testWithMethodAnnotationEquals() throws Exception {
  Annotation[] annotation1=Helper.class.getDeclaredMethod("getX").getAnnotations();
  Annotation[] annotation2=Helper.class.getDeclaredMethod("getX").getAnnotations();
  Arrays.sort(annotation1,(i,j) -> i.toString().compareTo(j.toString()));
  Arrays.sort(annotation2,(i,j) -> i.toString().compareTo(j.toString()));
  _checkWith(annotation1,annotation2);
  Annotation[] annotation3=Helper.class.getDeclaredMethod("getX").getAnnotations();
  Annotation[] annotation4=Helper.class.getDeclaredMethod("altX").getAnnotations();
  Arrays.sort(annotation3,(i,j) -> i.toString().compareTo(j.toString()));
  Arrays.sort(annotation4,(i,j) -> i.toString().compareTo(j.toString()));
  _checkWith(annotation3,annotation4);
}
