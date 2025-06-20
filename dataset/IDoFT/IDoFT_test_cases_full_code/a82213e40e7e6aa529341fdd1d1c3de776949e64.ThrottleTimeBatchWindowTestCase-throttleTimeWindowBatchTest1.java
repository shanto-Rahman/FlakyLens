@Test public void throttleTimeWindowBatchTest1() throws InterruptedException {
  SiddhiManager siddhiManager=new SiddhiManager();
  String cseEventStream="" + "define stream cseEventStream (symbol string, price float, volume int);";
  String query="" + "@info(name = 'query1') " + "from cseEventStream#throttler:timeBatch(5 sec) "+ "select symbol,sum(price) as sumPrice,volume, expiryTimeStamp "+ "insert all events into outputStream ;";
  SiddhiAppRuntime executionPlanRuntime=siddhiManager.createSiddhiAppRuntime(cseEventStream + query);
  executionPlanRuntime.addCallback("query1",new QueryCallback(){
    @Override public void receive(    long timeStamp,    Event[] inEvents,    Event[] removeEvents){
      EventPrinter.print(timeStamp,inEvents,removeEvents);
      if (inEvents != null) {
        inEventCount=inEventCount + inEvents.length;
      }
 else       if (removeEvents != null) {
        removeEventCount=removeEventCount + removeEvents.length;
      }
      eventArrived=true;
    }
  }
);
  InputHandler inputHandler=executionPlanRuntime.getInputHandler("cseEventStream");
  executionPlanRuntime.start();
  inputHandler.send(new Object[]{"IBM",700f,0});
  Thread.sleep(500);
  inputHandler.send(new Object[]{"WSO2",60.5f,1});
  Thread.sleep(6000);
  inputHandler.send(new Object[]{"IBM",700f,0});
  inputHandler.send(new Object[]{"WSO2",60.5f,1});
  Thread.sleep(6000);
  Assert.assertEquals(4,inEventCount);
  Assert.assertEquals(2,removeEventCount);
  Assert.assertTrue(eventArrived);
  executionPlanRuntime.shutdown();
}
