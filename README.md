## 病人健康状态监测系统：
### 描述
1. 所有用户（医生、患者、管理员）通过登录才可进入系统，登录信息提交后检验登录者的身份是否合法，合法，则转入对应的操作界面。并且由退出登录的操作。
2. 医生角色：可以查询和修改个人信息。医生可以查看自己的患者的全部信息但不能查看到其他的患者信息。医生可以接受管理员的识别的异常患者的告警信息。医生可以开处方药给自己的患者。
3. 患者角色：可以查询和修改个人信息、可以自主的选择医生，可以删除自己已选的医生，可以查看自己的已选医生。患者可以每日上报体温、脉搏、血压等健康状态信息到系统中。
4. 管理员角色：管理员可以浏览所有患者的健康状态信息，并统计患者的健康状态数据。可以识别异常的患者，提醒该患者选择的医生做相对应的操作。可以对医生和患者的个人信息进行增删改查操作，可以对医生的工作时间进行排班的操作。
