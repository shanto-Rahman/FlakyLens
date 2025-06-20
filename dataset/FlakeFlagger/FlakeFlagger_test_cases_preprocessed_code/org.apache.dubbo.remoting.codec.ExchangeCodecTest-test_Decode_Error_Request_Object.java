@Test public void test_Decode_Error_Request_Object() throws IOException {
Assert.assertEquals(true,obj.isBroken());
Assert.assertEquals(true,obj.getData() instanceof Throwable);
}