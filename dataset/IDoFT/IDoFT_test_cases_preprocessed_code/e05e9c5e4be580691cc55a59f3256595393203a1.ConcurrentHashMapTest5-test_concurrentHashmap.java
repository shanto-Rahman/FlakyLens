public void test_concurrentHashmap() throws Exception {
wrapper.offsetTable.put(new MessageQueue(),new WeakReference<A>(new A(true)));
Assert.assertEquals("{\"offsetTable\":{{\"items\":[]}:{\"value\":true}}}",text);
Assert.assertEquals(1,wrapper2.getOffsetTable().size());//IT
Iterator<Map.Entry<MessageQueue,WeakReference<A>>> iter=wrapper2.getOffsetTable().entrySet().iterator();//IT
Assert.assertEquals(0,entry.getKey().getItems().size());//IT
Assert.assertEquals(true,entry.getValue().get().isValue());//IT
}