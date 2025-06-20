@Test public void testDeserialize_Array() throws Exception {
Assert.assertTrue(obj.getClass().isArray());
Assert.assertTrue(int.class == obj.getClass().getComponentType());
Assert.assertEquals(i,Array.get(obj,i));
Assert.assertTrue(obj.getClass().isArray());
Assert.assertEquals(int[].class,obj.getClass().getComponentType());
Assert.assertTrue(innerItem.getClass().isArray());
Assert.assertEquals(int.class,innerItem.getClass().getComponentType());
Assert.assertEquals(j,Array.get(innerItem,j));
Assert.assertTrue(obj.getClass().isArray());
Assert.assertEquals(BigPerson[].class,obj.getClass().getComponentType());
Assert.assertEquals(1,Array.getLength(obj));
Assert.assertTrue(obj.getClass().isArray());
Assert.assertEquals(BigPerson.class,obj.getClass().getComponentType());
Assert.assertEquals(1,Array.getLength(obj));
Assert.assertEquals(createBigPerson(),Array.get(obj,0));
}