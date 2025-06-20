@Test public void embeddedServerWithDestinations(){
checker.checkQueue("Queue1",true);//IT
checker.checkQueue("Queue2",true);//IT
checker.checkQueue("QueueDoesNotExist",false);//IT
checker.checkTopic("Topic1",true);//IT
checker.checkTopic("TopicDoesNotExist",false);//IT
}