public void test_dupType2() throws Exception {
cart.setId(1001);//IT
Assert.assertEquals("{\"@type\":\"java.util.LinkedHashMap\",\"1001\":{\"id\":1001,\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteDuplicateType$DianDianCart\"}}",text1);
}