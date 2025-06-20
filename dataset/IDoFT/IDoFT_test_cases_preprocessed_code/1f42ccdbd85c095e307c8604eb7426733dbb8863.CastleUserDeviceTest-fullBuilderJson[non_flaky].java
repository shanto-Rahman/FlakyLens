@Test public void fullBuilderJson(){
Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
Assert.assertEquals(device.getToken(),DeviceUtils.DEVICE_TOKEN);
Assert.assertEquals(device.getCreatedAt(),DeviceUtils.DEVICE_CREATED_AT);
Assert.assertEquals(device.getLastSeenAt(),DeviceUtils.DEVICE_LAST_SEEN_AT);
Assert.assertEquals(device.getApprovedAt(),DeviceUtils.DEVICE_APPROVED_AT);
Assert.assertEquals(device.getEscalatedAt(),DeviceUtils.DEVICE_ESCALATED_AT);
Assert.assertEquals(device.getMitigatedAt(),DeviceUtils.DEVICE_MITIGATED_AT);
Assert.assertEquals(device.isCurrentDevice(),true);
Assert.assertEquals(device.getContext(),deviceContext);
}