@Test public void fullBuilderJson(){
Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
Assert.assertEquals(deviceContext.getIp(),DeviceUtils.CONTEXT_IP);
Assert.assertEquals(deviceContext.getType(),DeviceUtils.CONTEXT_TYPE);
Assert.assertEquals(deviceContext.getUserAgent(),userAgent);
}