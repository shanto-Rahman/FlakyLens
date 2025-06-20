public void testGhostTypeParameterWithClass(){
assertEquals(3,fields.length);
assertEquals("listOfT",listOfT_Field.getName());
assertEquals(List.class,listOfT_Type.getErasedType());
assertEquals("Expected 1 type parameter for listOfT, got " + listOfT_TypeParams.size() + ": "+ listOfT_TypeParams,1,listOfT_TypeParams.size());
assertEquals(Integer.class,listOfT_TypeParams.get(0).getErasedType());
assertEquals("t",t_Field.getName());
assertEquals(Integer.class,t_Type.getErasedType());
assertEquals("Expected 0 type parameter for t, got " + t_TypeParams.size() + ": "+ t_TypeParams,0,t_TypeParams.size());
assertEquals("i",i_Field.getName());
assertEquals(Integer.class,i_Type.getErasedType());
assertEquals("Expected 0 type parameter for i, got " + i_TypeParams.size() + ": "+ i_TypeParams,0,i_TypeParams.size());
}