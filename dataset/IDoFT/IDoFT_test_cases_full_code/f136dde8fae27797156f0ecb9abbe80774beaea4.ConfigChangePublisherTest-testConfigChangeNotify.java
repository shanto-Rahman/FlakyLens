@Test public void testConfigChangeNotify() throws InterruptedException {
  AtomicReference<ConfigDataChangeEvent> reference=new AtomicReference<>();
  NotifyCenter.registerToPublisher(ConfigDataChangeEvent.class,NotifyCenter.ringBufferSize);
  NotifyCenter.registerSubscriber(new Subscriber(){
    @Override public void onEvent(    Event event){
      reference.set((ConfigDataChangeEvent)event);
    }
    @Override public Class<? extends Event> subscribeType(){
      return ConfigDataChangeEvent.class;
    }
  }
);
  EnvUtil.setIsStandalone(true);
  PropertyUtil.setEmbeddedStorage(true);
  ConfigChangePublisher.notifyConfigChange(new ConfigDataChangeEvent("chuntaojun","chuntaojun",System.currentTimeMillis()));
  Thread.sleep(2000);
  Assert.assertNotNull(reference.get());
  reference.set(null);
  EnvUtil.setIsStandalone(true);
  PropertyUtil.setEmbeddedStorage(false);
  ConfigChangePublisher.notifyConfigChange(new ConfigDataChangeEvent("chuntaojun","chuntaojun",System.currentTimeMillis()));
  Thread.sleep(2000);
  Assert.assertNotNull(reference.get());
  reference.set(null);
  EnvUtil.setIsStandalone(false);
  PropertyUtil.setEmbeddedStorage(true);
  ConfigChangePublisher.notifyConfigChange(new ConfigDataChangeEvent("chuntaojun","chuntaojun",System.currentTimeMillis()));
  Thread.sleep(2000);
  Assert.assertNull(reference.get());
  reference.set(null);
  EnvUtil.setIsStandalone(false);
  PropertyUtil.setEmbeddedStorage(false);
  ConfigChangePublisher.notifyConfigChange(new ConfigDataChangeEvent("chuntaojun","chuntaojun",System.currentTimeMillis()));
  Thread.sleep(2000);
  Assert.assertNotNull(reference.get());
  reference.set(null);
}
