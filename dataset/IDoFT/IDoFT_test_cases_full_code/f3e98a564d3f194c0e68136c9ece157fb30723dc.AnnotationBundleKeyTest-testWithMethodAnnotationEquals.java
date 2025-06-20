public void testWithMethodAnnotationEquals() throws Exception {
  _checkWith(Helper.class.getDeclaredMethod("getX").getAnnotations(),Helper.class.getDeclaredMethod("getX").getAnnotations());
  _checkWith(Helper.class.getDeclaredMethod("getX").getAnnotations(),Helper.class.getDeclaredMethod("altX").getAnnotations());
}
