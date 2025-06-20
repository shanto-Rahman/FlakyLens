@Test public void load(){
  load(Externalizer.class);
  load(ClassTableContributor.class);
  load(IdentityGroupServiceConfiguratorProvider.class);
  load(IdentityCacheServiceConfiguratorProvider.class);
  load(DistributedGroupServiceConfiguratorProvider.class);
  load(DistributedCacheServiceConfiguratorProvider.class);
  load(LocalGroupServiceConfiguratorProvider.class);
  load(LocalCacheServiceConfiguratorProvider.class);
}
