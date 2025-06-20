@Test public void test_Encode_Request() throws IOException {
Assert.assertEquals(request.isBroken(),obj.isBroken());
Assert.assertEquals(request.isHeartbeat(),obj.isHeartbeat());
Assert.assertEquals(request.isTwoWay(),obj.isTwoWay());
Assert.assertEquals(person,obj.getData());
}