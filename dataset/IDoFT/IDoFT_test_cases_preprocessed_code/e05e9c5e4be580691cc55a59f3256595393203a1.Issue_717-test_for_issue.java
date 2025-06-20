public void test_for_issue() throws Exception {
group.setId(0L);//IT
group.setNAME("admin");//IT
group.setAUTHORITY("administrors");//IT
Assert.assertEquals("{\"ID\":0,\"nAME\":\"admin\"}",json);
}