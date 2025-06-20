public void test_0() throws Exception {
serializer.write(Type.A);//RW
Assert.assertTrue(size < JSONSerializerMapTest.size(serializer.getMapping()));
Assert.assertEquals(Integer.toString(Type.A.ordinal()),serializer.getWriter().toString());//RW
}