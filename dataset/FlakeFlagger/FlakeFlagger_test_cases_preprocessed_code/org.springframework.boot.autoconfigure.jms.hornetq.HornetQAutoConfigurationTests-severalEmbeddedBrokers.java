@Test public void severalEmbeddedBrokers(){
assertTrue("ServerId should not match",properties.getEmbedded().getServerId() < anotherProperties.getEmbedded().getServerId());
checker.checkQueue("Queue1",true);//IT
checker.checkQueue("Queue2",false);//IT
anotherChecker.checkQueue("Queue2",true);//IT
anotherChecker.checkQueue("Queue1",false);//IT
}