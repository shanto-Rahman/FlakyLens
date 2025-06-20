@Test public void fullBuilderJson(){
  DeviceUserAgent userAgent=new DeviceUserAgent();
  userAgent.setBrowser(DeviceUtils.USER_AGENT_BROWSER);
  userAgent.setDevice(DeviceUtils.USER_AGENT_DEVICE);
  userAgent.setFamily(DeviceUtils.USER_AGENT_FAMILY);
  userAgent.setMobile(DeviceUtils.USER_AGENT_MOBILE);
  userAgent.setOs(DeviceUtils.USER_AGENT_OS);
  userAgent.setPlatform(DeviceUtils.USER_AGENT_PLATFORM);
  userAgent.setRaw(DeviceUtils.USER_AGENT_PLATFORM);
  userAgent.setVersion(DeviceUtils.USER_AGENT_PLATFORM);
  String payloadJson=model.getGson().toJson(userAgent);
  Assertions.assertThat(payloadJson).isEqualTo("{\"raw\":\"Mac OS X\",\"browser\":\"Opera\",\"version\":\"Mac OS X\",\"os\":\"Mac OS X 10.13.6\",\"mobile\":false,\"platform\":\"Mac OS X\",\"device\":\"Unknown\",\"family\":\"Opera\"}");
  Assert.assertEquals(userAgent.getBrowser(),DeviceUtils.USER_AGENT_BROWSER);
  Assert.assertEquals(userAgent.getDevice(),DeviceUtils.USER_AGENT_DEVICE);
  Assert.assertEquals(userAgent.getFamily(),DeviceUtils.USER_AGENT_FAMILY);
  Assert.assertEquals(userAgent.isMobile(),DeviceUtils.USER_AGENT_MOBILE);
  Assert.assertEquals(userAgent.getOs(),DeviceUtils.USER_AGENT_OS);
  Assert.assertEquals(userAgent.getPlatform(),DeviceUtils.USER_AGENT_PLATFORM);
  Assert.assertEquals(userAgent.getRaw(),DeviceUtils.USER_AGENT_PLATFORM);
  Assert.assertEquals(userAgent.getVersion(),DeviceUtils.USER_AGENT_PLATFORM);
}
