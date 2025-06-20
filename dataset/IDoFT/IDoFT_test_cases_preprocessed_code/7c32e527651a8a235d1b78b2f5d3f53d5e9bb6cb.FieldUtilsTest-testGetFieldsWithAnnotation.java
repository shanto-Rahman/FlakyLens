@Test public void testGetFieldsWithAnnotation() throws NoSuchFieldException {
assertArrayEquals(new Field[0],FieldUtils.getFieldsWithAnnotation(Object.class,Annotated.class));
assertArrayEquals(annotatedFields,FieldUtils.getFieldsWithAnnotation(FieldUtilsTest.class,Annotated.class));
}