public void test_codec() throws Exception {
Assert.assertNotNull(model.value);
Assert.assertEquals(date.getTime(),model.value.getTime());
Assert.assertEquals(TimeZone.getTimeZone("Asia/Shanghai"),reader.getTimzeZone());
Assert.assertEquals(Locale.CHINA,reader.getLocal());
}