@Test public void testFilterDoesNotAffectHosts() throws Throwable {
  assertEquals(3,initialHostLinks.size());
  ContainerDescription desc=createContainerDescription(new String[]{});
  createContainer(desc,initialHostLinks.get(0));
  createContainer(desc,initialHostLinks.get(1));
  filter=new NamedVolumeAffinityHostFilter(host,desc);
  assertFalse(filter.isActive());
  Map<String,HostSelection> selected=filter();
  assertEquals(3,selected.size());
}
