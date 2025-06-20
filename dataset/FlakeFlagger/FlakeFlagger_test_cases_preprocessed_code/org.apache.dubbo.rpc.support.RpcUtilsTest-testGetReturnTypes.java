@Test public void testGetReturnTypes() throws Exception {
Assert.assertEquals(2,types.length);
Assert.assertEquals(String.class,types[0]);
Assert.assertEquals(String.class,types[1]);
Assert.assertEquals(2,types1.length);
Assert.assertEquals(List.class,types1[0]);
Assert.assertEquals(DemoService.class.getMethod("testReturnType1",new Class<?>[]{String.class}).getGenericReturnType(),types1[1]);
Assert.assertEquals(2,types2.length);
Assert.assertEquals(String.class,types2[0]);
Assert.assertEquals(String.class,types2[1]);
Assert.assertEquals(2,types3.length);
Assert.assertEquals(List.class,types3[0]);
Assert.assertEquals(((ParameterizedType)genericReturnType3).getActualTypeArguments()[0],types3[1]);
Assert.assertEquals(2,types4.length);
Assert.assertEquals(null,types4[0]);
Assert.assertEquals(null,types4[1]);
Assert.assertEquals(2,types5.length);
Assert.assertEquals(Map.class,types5[0]);
Assert.assertEquals(((ParameterizedType)genericReturnType5).getActualTypeArguments()[0],types5[1]);
}