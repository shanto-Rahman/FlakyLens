private void testCache(String type) throws Exception {
  ServiceConfig<CacheService> service=new ServiceConfig<CacheService>();
  service.setApplication(new ApplicationConfig("cache-provider"));
  service.setRegistry(new RegistryConfig("N/A"));
  service.setProtocol(new ProtocolConfig("injvm"));
  service.setInterface(CacheService.class.getName());
  service.setRef(new CacheServiceImpl());
  service.export();
  try {
    ReferenceConfig<CacheService> reference=new ReferenceConfig<CacheService>();
    reference.setApplication(new ApplicationConfig("cache-consumer"));
    reference.setInterface(CacheService.class);
    reference.setUrl("injvm://127.0.0.1?scope=remote&cache=true");
    MethodConfig method=new MethodConfig();
    method.setName("findCache");
    method.setCache(type);
    reference.setMethods(Arrays.asList(method));
    CacheService cacheService=reference.get();
    try {
      String fix=null;
      for (int i=0; i < 3; i++) {
        String result=cacheService.findCache("0");
        assertTrue(fix == null || fix.equals(result));
        fix=result;
        Thread.sleep(100);
      }
      if ("lru".equals(type)) {
        for (int n=0; n < 1001; n++) {
          String pre=null;
          for (int i=0; i < 10; i++) {
            String result=cacheService.findCache(String.valueOf(n));
            assertTrue(pre == null || pre.equals(result));
            pre=result;
          }
        }
        String result=cacheService.findCache("0");
        assertFalse(fix == null || fix.equals(result));
      }
    }
  finally {
      reference.destroy();
    }
  }
  finally {
    service.unexport();
  }
}
