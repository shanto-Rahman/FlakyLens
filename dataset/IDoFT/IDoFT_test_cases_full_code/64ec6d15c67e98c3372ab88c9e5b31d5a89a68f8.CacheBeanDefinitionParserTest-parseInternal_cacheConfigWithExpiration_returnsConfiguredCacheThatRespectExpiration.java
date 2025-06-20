@Test public void parseInternal_cacheConfigWithExpiration_returnsConfiguredCacheThatRespectExpiration() throws Exception {
  DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
  BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.rootBeanDefinition(Mockito.class);
  beanDefinitionBuilder.setFactoryMethod("mock");
  beanDefinitionBuilder.addConstructorArgValue(AmazonElastiCache.class);
  beanFactory.registerBeanDefinition(AmazonWebserviceClientConfigurationUtils.getBeanName(AmazonElastiCacheClient.class.getName()),beanDefinitionBuilder.getBeanDefinition());
  XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
  reader.loadBeanDefinitions(new ClassPathResource(getClass().getSimpleName() + "-cacheConfigWithExpiration.xml",getClass()));
  AmazonElastiCache client=beanFactory.getBean(AmazonWebserviceClientConfigurationUtils.getBeanName(AmazonElastiCacheClient.class.getName()),AmazonElastiCache.class);
  DescribeCacheClustersRequest memcached=new DescribeCacheClustersRequest().withCacheClusterId("memcached");
  memcached.setShowCacheNodeInfo(true);
  when(client.describeCacheClusters(memcached)).thenReturn(new DescribeCacheClustersResult().withCacheClusters(new CacheCluster().withCacheClusterId("memcached").withConfigurationEndpoint(new Endpoint().withAddress("localhost").withPort(Integer.parseInt(System.getProperty("memcachedPort")))).withCacheClusterStatus("available").withEngine("memcached")));
  CacheManager cacheManager=beanFactory.getBean(CacheManager.class);
  Cache cache=cacheManager.getCache("memcached");
  cache.put("foo","bar");
  Thread.sleep(2000);
  assertNotNull(cacheManager);
  assertNotNull(cache);
  assertNull(cache.get("foo"));
}
