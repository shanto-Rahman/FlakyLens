@Test public void test_Encode_Error_Response() throws IOException {
Assert.assertEquals(response.getId(),obj.getId());
Assert.assertEquals(response.getStatus(),obj.getStatus());
Assert.assertEquals(response.isHeartbeat(),obj.isHeartbeat());
Assert.assertEquals(badString,obj.getErrorMessage());
Assert.assertEquals(null,obj.getResult());
}