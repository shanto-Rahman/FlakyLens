@Test public void beanToXmlTest(){
schoolVo.setSchoolName("西安市第一中学");//IT
schoolVo.setSchoolAddress("西安市雁塔区长安堡一号");//IT
roomVo.setRoomName("101教室");//IT
roomVo.setRoomNo("101");//IT
schoolVo.setRoom(roomVo);//IT
Assert.assertEquals(xmlStr,JAXBUtil.beanToXml(schoolVo));
}