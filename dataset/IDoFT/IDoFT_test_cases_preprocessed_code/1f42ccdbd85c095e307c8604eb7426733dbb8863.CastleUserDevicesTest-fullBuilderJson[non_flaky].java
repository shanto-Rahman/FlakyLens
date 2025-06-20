@Test public void fullBuilderJson(){
Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
Assert.assertEquals(devices.getTotalCount(),devicesList.size());
Assert.assertEquals(devices.getDevices(),devicesList);
Assert.assertEquals(0,devices.getTotalCount());
}