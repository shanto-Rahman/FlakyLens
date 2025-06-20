@Test public void embeddedServiceWithCustomJmsConfiguration(){
checker.checkQueue("custom",true);//IT
checker.checkQueue("Queue1",false);//IT
checker.checkQueue("Queue2",false);//IT
}