@Test public void testList() throws Exception {
{
    TopicList topicList=new TopicList();
    Set<String> topicSet=new HashSet<>();
    topicSet.add("common_topic1");
    topicSet.add("common_topic2");
    topicSet.add("system_topic1");
    topicSet.add("system_topic2");
    topicSet.add("%DLQ%topic");
    topicSet.add("%RETRY%topic");
    topicList.setTopicList(topicSet);
    when(mqAdminExt.fetchAllTopicList()).thenReturn(topicList);
    TopicList sysTopicList=new TopicList();
    Set<String> sysTopicSet=new HashSet<>();
    sysTopicSet.add("system_topic1");
    sysTopicSet.add("system_topic2");
    sysTopicList.setTopicList(sysTopicSet);
    DefaultMQProducer producer=mock(DefaultMQProducer.class);
    doNothing().when(producer).start();
    doNothing().when(producer).shutdown();
    DefaultMQProducerImpl defaultMQProducer=mock(DefaultMQProducerImpl.class);
    MQClientInstance mqClientInstance=mock(MQClientInstance.class);
    MQClientAPIImpl mqClientAPIImpl=mock(MQClientAPIImpl.class);
    when(producer.getDefaultMQProducerImpl()).thenReturn(defaultMQProducer);
    when(defaultMQProducer.getmQClientFactory()).thenReturn(mqClientInstance);
    when(mqClientInstance.getMQClientAPIImpl()).thenReturn(mqClientAPIImpl);
    when(mqClientAPIImpl.getSystemTopicList(anyLong())).thenReturn(sysTopicList);
    doReturn(producer).when(topicService).buildDefaultMQProducer(anyString(),any(),anyBoolean());
  }
  final String url="/topic/list.query";
  requestBuilder=MockMvcRequestBuilders.get(url);
  requestBuilder.param("skipSysProcess",String.valueOf(true));
  perform=mockMvc.perform(requestBuilder);
  perform.andExpect(status().isOk()).andExpect(jsonPath("$.data.topicList",hasSize(6)));
  requestBuilder=MockMvcRequestBuilders.get(url);
  requestBuilder.param("skipSysProcess",String.valueOf(false));
  requestBuilder.param("skipRetryAndDlq",String.valueOf(true));
  perform=mockMvc.perform(requestBuilder);
  perform.andExpect(status().isOk()).andExpect(jsonPath("$.data.topicList",hasSize(4)));
  requestBuilder=MockMvcRequestBuilders.get(url);
  perform=mockMvc.perform(requestBuilder);
  perform.andExpect(status().isOk()).andExpect(jsonPath("$.data.topicList[2]").value("%SYS%system_topic1"));
}
