@Test public void fullBuilderJson(){
Assertions.assertThat(payloadJson).isEqualTo("{\"total_count\":1,\"data\":[{\"token\":\"abcdefg12345\",\"risk\":0.0,\"created_at\":\"2018-06-15T16:36:22.916Z\",\"last_seen_at\":\"2018-07-19T23:09:29.681Z\",\"context\":{\"ip\":\"1.1.1.1\",\"user_agent\":{\"raw\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36 OPR/54.0.2952.51\",\"browser\":\"Opera\",\"version\":\"54.0.2952\",\"os\":\"Mac OS X 10.13.6\",\"mobile\":false,\"platform\":\"Mac OS X\",\"device\":\"Unknown\",\"family\":\"Opera\"},\"type\":\"desktop\"},\"is_current_device\":true}]}");
Assert.assertEquals(devices.getTotalCount(),devicesList.size());
Assert.assertEquals(devices.getDevices(),devicesList);
Assert.assertEquals(0,devices.getTotalCount());
}