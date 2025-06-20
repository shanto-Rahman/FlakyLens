public void test_concurrentHashmap() throws Exception {
  OffsetSerializeWrapper wrapper=new OffsetSerializeWrapper();
  wrapper.offsetTable.put(new MessageQueue(),new WeakReference<A>(new A(true)));
  String text=JSON.toJSONString(wrapper,new SerializeConfig());
  Assert.assertEquals("{\"offsetTable\":{{\"items\":[]}:{\"value\":true}}}",text);
  OffsetSerializeWrapper wrapper2=JSON.parseObject(text,OffsetSerializeWrapper.class);
  Assert.assertEquals(1,wrapper2.getOffsetTable().size());
  Iterator<Map.Entry<MessageQueue,WeakReference<A>>> iter=wrapper2.getOffsetTable().entrySet().iterator();
  Map.Entry<MessageQueue,WeakReference<A>> entry=iter.next();
  Assert.assertEquals(0,entry.getKey().getItems().size());
  Assert.assertEquals(true,entry.getValue().get().isValue());
}
