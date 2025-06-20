@Test(description="Test get Error DTO as String") public void testGetErrorDTO2() throws Exception {
  ErrorHandler errorHandler=Mockito.mock(ErrorHandler.class);
  Map<String,String> paramList=new HashMap<>();
  APIManagementException ex=Mockito.mock(APIManagementException.class);
  paramList.put("param1","test1");
  paramList.put("param2","test2");
  paramList.put("param3","test3");
  when(errorHandler.getErrorDescription()).thenReturn("Test Error Description");
  when(ex.getMessage()).thenReturn("Error Message");
  when(errorHandler.getErrorCode()).thenReturn((long)900300);
  final String expectedErrorDTOString1="class ErrorDTO {\n" + "  code: 900300\n" + "  message: Error Message\n"+ "  description: Test Error Description\n"+ "  moreInfo: {param3=test3, param1=test1, param2=test2}\n"+ "  error: []\n"+ "}\n";
  final String expectedErrorDTOString2="class ErrorDTO {\n" + "  code: 900300\n" + "  message: null\n"+ "  description: Test Error Description\n"+ "  moreInfo: {param3=test3, param1=test1, param2=test2}\n"+ "  error: []\n"+ "}\n";
  ErrorDTO errorDTO1=RestApiUtil.getErrorDTO(errorHandler,(HashMap<String,String>)paramList,ex);
  Assert.assertEquals(errorDTO1.toString(),expectedErrorDTOString1);
  when(ex.getMessage()).thenReturn(null);
  ErrorDTO errorDTO2=RestApiUtil.getErrorDTO(errorHandler,(HashMap<String,String>)paramList,ex);
  Assert.assertEquals(errorDTO2.toString(),expectedErrorDTOString2);
}
