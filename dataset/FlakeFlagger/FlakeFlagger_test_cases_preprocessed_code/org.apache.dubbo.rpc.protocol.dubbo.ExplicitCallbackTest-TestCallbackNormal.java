@Test public void TestCallbackNormal() throws Exception {
demoProxy.xxx(new IDemoCallback(){
  public String yyy(  String msg){
    System.out.println("Recived callback: " + msg);
    count.incrementAndGet();
    return "ok";
  }
}
,"other custom args",10,100);//IT
count.incrementAndGet();
}