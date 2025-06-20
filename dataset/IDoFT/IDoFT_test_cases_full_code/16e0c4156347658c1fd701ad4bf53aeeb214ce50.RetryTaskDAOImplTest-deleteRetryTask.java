@Test @Order(4) void deleteRetryTask(){
  final RetryTaskPO retryTaskPO=new RetryTaskPO().setId(1L);
  boolean b=retryTaskDAO.deleteRetryTask(retryTaskPO);
  Assertions.assertTrue(b);
  final RetryTaskQuery retryTaskQuery=new RetryTaskQuery().setRetryStatus(Collections.singletonList(RetryTaskStatusEnum.FINISH.getCode()));
  List<RetryTaskPO> retryTaskPOS=retryTaskDAO.listRetryTask(retryTaskQuery);
  System.out.println(retryTaskPOS);
  Assertions.assertTrue(Objects.isNull(retryTaskPOS) || retryTaskPOS.isEmpty());
}
