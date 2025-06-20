public void testJpaVariableHappyPath(){
assertNotNull(value);
assertTrue(value instanceof LoanRequest);
assertEquals("John Doe",request.getCustomerName());
assertEquals(15000L,request.getAmount().longValue());
assertFalse(request.isApproved());
assertNotNull(task);
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
}