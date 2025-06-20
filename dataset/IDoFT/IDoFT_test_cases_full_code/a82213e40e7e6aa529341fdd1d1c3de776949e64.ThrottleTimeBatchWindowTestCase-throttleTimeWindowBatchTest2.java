@Test public void throttleTimeWindowBatchTest2() throws InterruptedException {
  SiddhiManager siddhiManager=new SiddhiManager();
  String cseEventStream="" + "define stream cseEventStream (symbol string, price float, volume int);";
  String query="" + "@info(name = 'query1') " + "from cseEventStream#throttler:timeBatch(5 sec , 0) "+ "select symbol,sum(price) as sumPrice,volume, expiryTimeStamp "+ "insert all events into outputStream ;";
  SiddhiAppRuntime executionPlanRuntime=siddhiManager.createSiddhiAppRuntime(cseEventStream + query);
  executionPlanRuntime.addCallback("query1",new QueryCallback(){
    @Override public void receive(    long timeStamp,    Event[] inEvents,    Event[] removeEvents){
      EventPrinter.print(timeStamp,inEvents,removeEvents);
      if (inEvents != null) {
        inEventCount=inEventCount + inEvents.length;
      }
 else       if (removeEvents != null) {
        removeEventCount=removeEventCount + removeEvents.length;
        lastRemoveEvent=removeEvents[removeEvents.length - 1];
      }
      eventArrived=true;
    }
  }
);
  InputHandler inputHandler=executionPlanRuntime.getInputHandler("cseEventStream");
  executionPlanRuntime.start();
  inputHandler.send(new Object[]{"IBM",700f,0});
  inputHandler.send(new Object[]{"WSO2",60.5f,1});
  Thread.sleep(10000);
  Assert.assertEquals(2,inEventCount);
  Assert.assertEquals("WSO2",lastRemoveEvent.getData()[0]);
  Assert.assertTrue(eventArrived);
  executionPlanRuntime.shutdown();
}
