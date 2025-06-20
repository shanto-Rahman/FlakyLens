@Test public void fullBuilderJson(){
Assertions.assertThat(payloadJson).isEqualTo("{\"token\":\"abcdefg12345\",\"risk\":0.0,\"created_at\":\"2018-06-15T16:36:22.916Z\",\"last_seen_at\":\"2018-07-19T23:09:29.681Z\",\"context\":{\"ip\":\"1.1.1.1\",\"user_agent\":{\"raw\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36 OPR/54.0.2952.51\",\"browser\":\"Opera\",\"version\":\"54.0.2952\",\"os\":\"Mac OS X 10.13.6\",\"mobile\":false,\"platform\":\"Mac OS X\",\"device\":\"Unknown\",\"family\":\"Opera\"},\"type\":\"desktop\"},\"is_current_device\":true}");
Assert.assertEquals(device.getToken(),DeviceUtils.DEVICE_TOKEN);
Assert.assertEquals(device.getCreatedAt(),DeviceUtils.DEVICE_CREATED_AT);
Assert.assertEquals(device.getLastSeenAt(),DeviceUtils.DEVICE_LAST_SEEN_AT);
Assert.assertEquals(device.getApprovedAt(),DeviceUtils.DEVICE_APPROVED_AT);
Assert.assertEquals(device.getEscalatedAt(),DeviceUtils.DEVICE_ESCALATED_AT);
Assert.assertEquals(device.getMitigatedAt(),DeviceUtils.DEVICE_MITIGATED_AT);
Assert.assertEquals(device.isCurrentDevice(),true);
Assert.assertEquals(device.getContext(),deviceContext);
}