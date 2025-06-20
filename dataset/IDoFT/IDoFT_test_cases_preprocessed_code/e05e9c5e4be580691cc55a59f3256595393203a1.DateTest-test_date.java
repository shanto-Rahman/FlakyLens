public void test_date() throws Exception {
Assert.assertEquals("1324138987429",JSON.toJSONString(date));
Assert.assertEquals("new Date(1324138987429)",JSON.toJSONString(date,SerializerFeature.WriteClassName));
Assert.assertEquals("\"2011-12-18 00:23:07\"",JSON.toJSONString(date,SerializerFeature.WriteDateUseDateFormat));
Assert.assertEquals("\"2011-12-18 00:23:07.429\"",JSON.toJSONStringWithDateFormat(date,"yyyy-MM-dd HH:mm:ss.SSS"));
Assert.assertEquals("'2011-12-18 00:23:07.429'",JSON.toJSONStringWithDateFormat(date,"yyyy-MM-dd HH:mm:ss.SSS",SerializerFeature.UseSingleQuotes));
}