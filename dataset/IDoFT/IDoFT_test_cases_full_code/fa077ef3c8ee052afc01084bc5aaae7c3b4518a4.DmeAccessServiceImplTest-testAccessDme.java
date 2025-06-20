/** 
 * Method: accessDme(Map<String, Object> params)
 */
@Test public void testAccessDme() throws Exception {
  Map<String,Object> params=new HashMap<>();
  params.put("userName",userName);
  params.put("password",password);
  params.put("hostIp",hostIp);
  params.put("hostPort",hostPort);
  dmeAccessService.accessDme(params);
}
