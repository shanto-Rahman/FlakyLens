@Test public void test_Decode_Return_Response_Error() throws IOException {
Assert.assertEquals(90,obj.getStatus());
Assert.assertEquals(errorString,obj.getErrorMessage());
}