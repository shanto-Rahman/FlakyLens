public void testJpaVariableDisapprovalPath(){
assertNotNull(value);
assertTrue(value instanceof LoanRequest);
assertEquals("Jane Doe",request.getCustomerName());
assertEquals(50000L,request.getAmount().longValue());
assertFalse(request.isApproved());
assertNotNull(task);
assertFalse(request.isApproved());
assertNotNull(task);
assertEquals("Send rejection letter",task.getName());
}