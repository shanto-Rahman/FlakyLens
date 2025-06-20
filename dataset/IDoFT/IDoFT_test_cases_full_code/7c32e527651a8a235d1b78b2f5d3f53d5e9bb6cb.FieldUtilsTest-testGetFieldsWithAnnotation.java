@Test public void testGetFieldsWithAnnotation() throws NoSuchFieldException {
  assertArrayEquals(new Field[0],FieldUtils.getFieldsWithAnnotation(Object.class,Annotated.class));
  final Field[] annotatedFields=new Field[]{FieldUtilsTest.class.getDeclaredField("publicChild"),FieldUtilsTest.class.getDeclaredField("privatelyShadowedChild")};
  assertArrayEquals(annotatedFields,FieldUtils.getFieldsWithAnnotation(FieldUtilsTest.class,Annotated.class));
}
