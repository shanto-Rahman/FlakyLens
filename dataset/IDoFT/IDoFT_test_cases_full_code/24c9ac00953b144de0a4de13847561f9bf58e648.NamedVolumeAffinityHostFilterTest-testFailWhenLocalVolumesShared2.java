@Test public void testFailWhenLocalVolumesShared2() throws Throwable {
  ContainerVolumeDescription local1=createVolumeDescription("vol1","local");
  ContainerDescription c1=createContainerDescription(new String[]{"vol1:/tmp"});
  CompositeDescription compositeDesc=createCompositeDesc(false,false,local1,c1);
  ContainerVolumeState volume=createVolumeState(local1);
  createCompositeComponent(compositeDesc,volume);
  String h1Link=createDockerHostWithVolumeDrivers("local");
  createContainer(c1,h1Link);
  initialHostLinks.remove(h1Link);
  assertEquals(3,initialHostLinks.size());
  ContainerDescription c2=createContainerDescription(new String[]{"vol1:/tmp"});
  filter=new NamedVolumeAffinityHostFilter(host,c2);
  Throwable e=filter(initialHostLinks);
  if (e == null) {
    fail("Expected exception");
  }
  if (e instanceof LocalizableValidationException) {
    LocalizableValidationException le=(LocalizableValidationException)e;
    assertThat(le.getMessage(),startsWith("Unable to place containers sharing local volumes"));
  }
 else {
    fail("Expected LocalizableValidationException");
  }
}
