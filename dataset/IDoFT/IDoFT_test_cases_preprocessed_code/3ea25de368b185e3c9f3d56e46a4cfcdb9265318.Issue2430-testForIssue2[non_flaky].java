public void testForIssue2(){
assertEquals("VO:{name->zhangsan,map->{a=[1, 2, 3], b=[1]}}",JSON.toJSONString(vo,SerializerFeature.MapSortField));
}