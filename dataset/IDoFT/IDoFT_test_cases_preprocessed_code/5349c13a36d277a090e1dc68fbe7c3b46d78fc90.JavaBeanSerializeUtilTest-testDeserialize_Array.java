@Test public void testDeserialize_Array(){
Assertions.assertTrue(obj.getClass().isArray());
Assertions.assertSame(int.class,obj.getClass().getComponentType());
Assertions.assertEquals(i,Array.get(obj,i));
Assertions.assertTrue(obj.getClass().isArray());
Assertions.assertEquals(int[].class,obj.getClass().getComponentType());
Assertions.assertTrue(innerItem.getClass().isArray());
Assertions.assertEquals(int.class,innerItem.getClass().getComponentType());
Assertions.assertEquals(j,Array.get(innerItem,j));
Assertions.assertTrue(obj.getClass().isArray());
Assertions.assertEquals(BigPerson[].class,obj.getClass().getComponentType());
Assertions.assertEquals(1,Array.getLength(obj));
Assertions.assertTrue(obj.getClass().isArray());
Assertions.assertEquals(BigPerson.class,obj.getClass().getComponentType());
Assertions.assertEquals(1,Array.getLength(obj));
Assertions.assertEquals(createBigPerson(),Array.get(obj,0));
}