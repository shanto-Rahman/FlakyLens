/** 
 * Test to make sure that all the actively called method on MetricsHBaseServer work.
 */
@Test public void testSourceMethods(){
  MetricsHBaseServer mrpc=new MetricsHBaseServer("HMaster",new MetricsHBaseServerWrapperStub());
  MetricsHBaseServerSource serverSource=mrpc.getMetricsSource();
  for (int i=0; i < 12; i++) {
    mrpc.authenticationFailure();
  }
  for (int i=0; i < 13; i++) {
    mrpc.authenticationSuccess();
  }
  HELPER.assertCounter("authenticationFailures",12,serverSource);
  HELPER.assertCounter("authenticationSuccesses",13,serverSource);
  for (int i=0; i < 14; i++) {
    mrpc.authorizationSuccess();
  }
  for (int i=0; i < 15; i++) {
    mrpc.authorizationFailure();
  }
  HELPER.assertCounter("authorizationSuccesses",14,serverSource);
  HELPER.assertCounter("authorizationFailures",15,serverSource);
  mrpc.dequeuedCall(100);
  mrpc.processedCall(101);
  mrpc.totalCall(102);
  HELPER.assertCounter("queueCallTime_NumOps",1,serverSource);
  HELPER.assertCounter("processCallTime_NumOps",1,serverSource);
  HELPER.assertCounter("totalCallTime_NumOps",1,serverSource);
  mrpc.sentBytes(103);
  mrpc.sentBytes(103);
  mrpc.sentBytes(103);
  mrpc.receivedBytes(104);
  mrpc.receivedBytes(104);
  HELPER.assertCounter("sentBytes",309,serverSource);
  HELPER.assertCounter("receivedBytes",208,serverSource);
  mrpc.receivedRequest(105);
  mrpc.sentResponse(106);
  HELPER.assertCounter("requestSize_NumOps",1,serverSource);
  HELPER.assertCounter("responseSize_NumOps",1,serverSource);
  mrpc.exception(null);
  HELPER.assertCounter("exceptions",1,serverSource);
  mrpc.exception(new RegionMovedException(ServerName.parseServerName("localhost:60020"),100));
  mrpc.exception(new RegionTooBusyException("Some region"));
  mrpc.exception(new OutOfOrderScannerNextException());
  mrpc.exception(new NotServingRegionException());
  HELPER.assertCounter("exceptions.RegionMovedException",1,serverSource);
  HELPER.assertCounter("exceptions.RegionTooBusyException",1,serverSource);
  HELPER.assertCounter("exceptions.OutOfOrderScannerNextException",1,serverSource);
  HELPER.assertCounter("exceptions.NotServingRegionException",1,serverSource);
  HELPER.assertCounter("exceptions",5,serverSource);
}
