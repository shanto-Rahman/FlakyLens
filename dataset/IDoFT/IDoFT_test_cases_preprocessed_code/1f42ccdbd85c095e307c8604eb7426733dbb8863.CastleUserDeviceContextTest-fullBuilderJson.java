@Test public void fullBuilderJson(){
Assertions.assertThat(payloadJson).isEqualTo("{\"ip\":\"1.1.1.1\",\"user_agent\":{\"raw\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36 OPR/54.0.2952.51\",\"browser\":\"Opera\",\"version\":\"54.0.2952\",\"os\":\"Mac OS X 10.13.6\",\"mobile\":false,\"platform\":\"Mac OS X\",\"device\":\"Unknown\",\"family\":\"Opera\"},\"type\":\"desktop\"}");
Assert.assertEquals(deviceContext.getIp(),DeviceUtils.CONTEXT_IP);
Assert.assertEquals(deviceContext.getType(),DeviceUtils.CONTEXT_TYPE);
Assert.assertEquals(deviceContext.getUserAgent(),userAgent);
}