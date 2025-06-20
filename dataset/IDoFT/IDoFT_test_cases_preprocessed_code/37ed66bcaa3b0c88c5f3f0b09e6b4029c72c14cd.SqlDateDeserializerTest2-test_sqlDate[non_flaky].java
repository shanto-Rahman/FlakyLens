public void test_sqlDate() throws Exception {
Assert.assertNull(JSON.parseObject("null",Date.class));
Assert.assertNull(JSON.parseObject("\"\"",Date.class));
Assert.assertNull(JSON.parseArray("null",Date.class));
Assert.assertNull(JSON.parseArray("[null]",Date.class).get(0));
Assert.assertNull(JSON.parseObject("{\"value\":null}",VO.class).getValue());
Assert.assertEquals(new Date(millis),JSON.parseObject("" + millis,Date.class));
Assert.assertEquals(new Date(millis),JSON.parseObject("{\"@type\":\"java.sql.Date\",\"val\":" + millis + "}",Date.class));
Assert.assertEquals(new Date(millis),JSON.parseObject("\"" + millis + "\"",Date.class));
Assert.assertEquals(new Date(millis2),JSON.parseObject("\"" + text2 + "\"",Date.class));
Assert.assertEquals(new Date(millis),JSON.parseObject("\"" + text + "\"",Date.class));
}