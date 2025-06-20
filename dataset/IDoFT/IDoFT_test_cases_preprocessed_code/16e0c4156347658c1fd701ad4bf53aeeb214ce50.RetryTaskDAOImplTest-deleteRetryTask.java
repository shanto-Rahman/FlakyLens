@Test @Order(4) void deleteRetryTask(){
boolean b=retryTaskDAO.deleteRetryTask(retryTaskPO);//RW
Assertions.assertTrue(b);
List<RetryTaskPO> retryTaskPOS=retryTaskDAO.listRetryTask(retryTaskQuery);//RW
Assertions.assertTrue(Objects.isNull(retryTaskPOS) || retryTaskPOS.isEmpty());
}