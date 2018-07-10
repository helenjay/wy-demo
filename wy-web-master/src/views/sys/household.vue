<template>
	<div style="margin: 20px;">
        <div>
            <Row style="margin-bottom: 25px;">
                <Col span="8">住户名称：
                    <Select v-model="householdId" filterable clearable style="width: 200px">
                        <Option v-for="item in householdList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </Col>
                <Col span="8"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
            </Row>
        </div>            
        <div>
            <ul>
                <li>
                    <Button type="primary" icon="plus-round" @click="openNewModal()">新建</Button>
                    <Button type="success" icon="wrench" @click="openModifyModal()">修改</Button>
                    <Button type="error" icon="trash-a" @click="del()">删除</Button>
                </li>
                <li>
                    <div style="padding: 10px 0;">
                    	<Table border :columns="columns1" :data="data1" :height="400" @on-selection-change="s=>{change(s)}" @on-row-dblclick="s=>{dblclick(s)}"></Table>
                    </div> 
                </li>
                <li>
                    <div style="text-align: right;">
                        <Page :total="total" :page-size="pageInfo.pageSize" show-elevator show-total @on-change="e=>{pageSearch(e)}"></Page>
                    </div>  
                </li>
            </ul>
        </div>
        <!--添加modal-->  
        <Modal :mask-closable="false" :visible.sync="newModal" :loading = "loading" v-model="newModal" width="600" title="新建" @on-ok="newOk('householdNew')" @on-cancel="cancel()">
            <Form ref="householdNew" :model="householdNew" :rules="ruleNew" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="住户名称:" prop="householdName">
                            <Input v-model="householdNew.householdName" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="住户性别:" prop="sex">
                            <Input v-model="householdNew.sex" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="出生日期:" prop="birthday">
                            <Input v-model="householdNew.birthday" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="身份类型:" prop="identityType">
                            <Input v-model="householdNew.identityType" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="工作单位:" prop="company">
                        <Input v-model="householdNew.company" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="工作部门:" prop="department">
                        <Input v-model="householdNew.department" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="证件类型:" prop="cardType">
                        <Input v-model="householdNew.cardType" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="证件号码:" prop="cardNo">
                        <Input v-model="householdNew.cardNo" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="手机号码:" prop="mobile">
                        <Input v-model="householdNew.mobile" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="户籍地址:" prop="address">
                        <Input v-model="householdNew.address" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="身份证正面照片:" prop="idCardImage1">
                        <Input v-model="householdNew.idCardImage1" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="身份证反面照片:" prop="idCardImage2">
                        <Input v-model="householdNew.idCardImage2" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <!--<Row>-->
                    <!--<Col span="12">-->
                        <!--<Form-item label="图标:" prop="icon">-->
                            <!--<Input v-model="householdNew.icon" style="width: 204px"/>-->
                        <!--</Form-item>-->
                    <!--</Col>-->
                <!--</Row>-->
                <!--<Form-item label="描述:" prop="remark">-->
                     <!--<Input v-model="householdNew.remark" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>-->
                <!--</Form-item>-->
            </Form>
        </Modal>
        <!--修改modal-->  
        <Modal :mask-closable="false" :visible.sync="modifyModal" :loading = "loading" v-model="modifyModal" width="600" title="修改" @on-ok="modifyOk('householdModify')" @on-cancel="cancel()">
            <Form ref="householdModify" :model="householdModify" :rules="ruleModify" :label-width="80" >
                <Row>
                    <Col span="12">
                    <Form-item label="住户名称:" prop="householdName">
                        <Input v-model="householdModify.householdName" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="住户性别:" prop="sex">
                        <Input v-model="householdModify.sex" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="出生日期:" prop="birthday">
                        <Input v-model="householdModify.birthday" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="身份类型:" prop="identityType">
                        <Input v-model="householdModify.identityType" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="工作单位:" prop="company">
                        <Input v-model="householdModify.company" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="工作部门:" prop="department">
                        <Input v-model="householdModify.department" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="证件类型:" prop="cardType">
                        <Input v-model="householdModify.cardType" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="证件号码:" prop="cardNo">
                        <Input v-model="householdModify.cardNo" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="手机号码:" prop="mobile">
                        <Input v-model="householdModify.mobile" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="户籍地址:" prop="address">
                        <Input v-model="householdModify.address" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="身份证正面照片:" prop="idCardImage1">
                        <Input v-model="householdModify.idCardImage1" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="身份证反面照片:" prop="idCardImage2">
                        <Input v-model="householdModify.idCardImage2" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
            </Form>
        </Modal>
    </div>
</template>
<script>
	export default {
        data () {
            return {
                /*用于查找的菜单id*/
                householdId:null,
            	/*选择的数量*/
                count:null,
            	/*选中的组数据*/
                groupId:null,
            	/*新建modal的显示参数*/
                newModal:false,
                /*修改modal的显示参数*/
                modifyModal:false,
            	/*分页total属性绑定值*/
                total:0,
                /*loading*/
                loading: true,
                /*pageInfo实体*/
                pageInfo:{
                	page:0,
                	pageSize:10
                },
                /*household实体*/
                household:{
                    id:null,
                    houseId:null,
                    householdName:null,
                    sex:null,
                    birthday:null,
                    identityType:null,
                    company:null,
                    department:null,
                    cardType:null,
                    cardNo:null,
                    mobile:null,
                    createTime:null,
                    modifyTime:null,
                    authStatus:null,
                    idCardImage1:null,
                    idCardImage2:null,
                    currentImage:null,
                    address:null,
                    status:null
                },
                /*用于添加的household实体*/
                householdNew:{
                    id:null,
                    houseId:null,
                    householdName:null,
                    sex:null,
                    birthday:null,
                    identityType:null,
                    company:null,
                    department:null,
                    cardType:null,
                    cardNo:null,
                    mobile:null,
                    createTime:null,
                    modifyTime:null,
                    authStatus:null,
                    idCardImage1:null,
                    idCardImage2:null,
                    currentImage:null,
                    address:null,
                    status:null
                },
                /*用于修改的household实体*/
                householdModify:{
                    id:null,
                    houseId:null,
                    householdName:null,
                    sex:null,
                    birthday:null,
                    identityType:null,
                    company:null,
                    department:null,
                    cardType:null,
                    cardNo:null,
                    mobile:null,
                    createTime:null,
                    modifyTime:null,
                    authStatus:null,
                    idCardImage1:null,
                    idCardImage2:null,
                    currentImage:null,
                    address:null,
                    status:null
                },
                /*新建验证*/
                ruleNew:{
                    householdName: [
                        { type:'string',required: true, message: '输入住户名称', trigger: 'blur' }
                    ],
                    houseId: [
                        { type:'string',required: true, message: '选择关联房屋', trigger: 'blur' }
                    ]
//                    parentId: [
//                        { required: true, message: '输入父类ID', trigger: 'blur' },
//                        {validator(rule, value, callback) {
//                            if (!Number.isInteger(+value)) {
//                                callback(new Error('请输入数字'));
//                            } else {
//                                callback();
//                            }
//
//                        }, trigger: 'blur'}
//                    ],
//                    sort: [
//                        { required: true, message: '输入排序', trigger: 'blur' },
//                        {validator(rule, value, callback) {
//                            if (!Number.isInteger(+value)) {
//                                callback(new Error('请输入数字'));
//                            } else {
//                                callback();
//                            }
//
//                        }, trigger: 'blur'}
//                    ],
//                    icon: [
//                        { type:'string',required: true, message: '输入图标', trigger: 'blur' }
//                    ]
                },
                /*修改验证*/
                ruleModify:{
                    householdName: [
                        { type:'string',required: true, message: '输入住户名称', trigger: 'blur' }
                    ],
                    houseId: [
                        { type:'string',required: true, message: '选择关联房屋', trigger: 'blur' }
                    ]/*,
                    parentId: [
                        { required: true, message: '输入父类ID', trigger: 'blur' },
                        {validator(rule, value, callback) {
                            if (!Number.isInteger(+value)) {
                                callback(new Error('请输入数字'));
                            } else {
                                callback();
                            }
                          
                        }, trigger: 'blur'}
                    ],
                    sort: [
                        { required: true, message: '输入排序', trigger: 'blur' },
                        {validator(rule, value, callback) {
                            if (!Number.isInteger(+value)) {
                                callback(new Error('请输入数字'));
                            } else {
                                callback();
                            }
                          
                        }, trigger: 'blur'}
                    ],
                    icon: [
                        { type:'string',required: true, message: '输入图标', trigger: 'blur' }
                    ]*/
                },
                /*菜单列表*/
                householdList:[],
            	/*生产类型表显示字段*/
            	columns1: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '住户ID',
                        key: 'id'
                    },
                    {
                        title: '住户名',
                        key: 'householdName'
                    },
                    {
                        title: '性别',
                        key: 'sex'
                    },
                    {
                        title: '出生日期',
                        key: 'birthday'
                    },
                    {
                        title: '是否是业主',
                        key: 'identityType'
                    },
                    {
                        title: '工作单位',
                        key: 'company'
                    }
                ],
                /*生产类型表数据*/
                data1: []
            }
        },
        mounted(){
        	/*页面初始化调用方法*/
            this.getTable({
                "pageInfo":this.pageInfo,
                'householdId':this.householdId
            });
//            this.axios({
//              method: 'get',
//              url: '/households'
//            }).then(function (response) {
//                var listTemp = response.data;
//                for (var i = 0; i < listTemp.length; i++) {
//                    this.householdList.push({
//                        "value": listTemp[i].id,
//                        "label": listTemp[i].name
//                    });
//                }
//            }.bind(this)).catch(function (error) {
//              //alert(error);
//            });
        },
        methods:{
        	/*pageInfo实体初始化*/
        	initPageInfo(){
        		this.pageInfo.page = 0;
        		this.pageInfo.pageSize = 10;
        	},
            /*household实体初始化*/
            initHousehold(){
                this.household.id = null;
                this.household.houseId = null;
                this.household.householdName = null;
                this.household.sex = null;
                this.household.birthday = null;
                this.household.identityType = null;
                this.household.company = null;
                this.household.department = null;
                this.household.cardType = null;
                this.household.cardNo = null;
                this.household.mobile = null;
                this.household.createTime = null;
                this.household.modifyTime = null;
                this.household.authStatus = null;
                this.household.idCardImage1 = null;
                this.household.idCardImage2 = null;
                this.household.currentImage = null;
                this.household.address = null;
                this.household.status = null;
            },
            /*householdNew实体初始化*/
            initHouseholdNew(){
                this.householdNew.id = null;
                this.householdNew.houseId = null;
                this.householdNew.householdName = null;
                this.householdNew.sex = null;
                this.householdNew.birthday = null;
                this.householdNew.identityType = null;
                this.householdNew.company = null;
                this.householdNew.department = null;
                this.householdNew.cardType = null;
                this.householdNew.cardNo = null;
                this.householdNew.mobile = null;
                this.householdNew.createTime = null;
                this.householdNew.modifyTime = null;
                this.householdNew.authStatus = null;
                this.householdNew.idCardImage1 = null;
                this.householdNew.idCardImage2 = null;
                this.householdNew.currentImage = null;
                this.householdNew.address = null;
                this.householdNew.status = null;
            },
            /*householdModify实体初始化*/
            initHouseholdModify(){
                this.householdModify.id = null;
                this.householdModify.houseId = null;
                this.householdModify.householdName = null;
                this.householdModify.sex = null;
                this.householdModify.birthday = null;
                this.householdModify.identityType = null;
                this.householdModify.company = null;
                this.householdModify.department = null;
                this.householdModify.cardType = null;
                this.householdModify.cardNo = null;
                this.householdModify.mobile = null;
                this.householdModify.createTime = null;
                this.householdModify.modifyTime = null;
                this.householdModify.authStatus = null;
                this.householdModify.idCardImage1 = null;
                this.householdModify.idCardImage2 = null;
                this.householdModify.currentImage = null;
                this.householdModify.address = null;
                this.householdModify.status = null;
            },
            /*householdNew设置*/
            householdSet(e){
                this.household.id = e.id;
                this.household.houseId = e.houseId;
                this.household.householdName = e.householdName;
                this.household.sex = e.sex;
                this.household.birthday = e.birthday;
                this.household.identityType = e.identityType;
                this.household.company = e.company;
                this.household.department = e.department;
                this.household.cardType = e.cardType;
                this.household.cardNo = e.cardNo;
                this.household.mobile = e.mobile;
                this.household.createTime = e.createTime;
                this.household.modifyTime = e.modifyTime;
                this.household.authStatus = e.authStatus;
                this.household.idCardImage1 = e.idCardImage1;
                this.household.idCardImage2 = e.idCardImage2;
                this.household.currentImage = e.currentImage;
                this.household.address = e.address;
                this.household.status = e.status;
            },
            /*householdNew设置*/
            householdNewSet(e){
                this.householdNew.id = e.id;
                this.householdNew.houseId = e.houseId;
                this.householdNew.householdName = e.householdName;
                this.householdNew.sex = e.sex;
                this.householdNew.birthday = e.birthday;
                this.householdNew.identityType = e.identityType;
                this.householdNew.company = e.company;
                this.householdNew.department = e.department;
                this.householdNew.cardType = e.cardType;
                this.householdNew.cardNo = e.cardNo;
                this.householdNew.mobile = e.mobile;
                this.householdNew.createTime = e.createTime;
                this.householdNew.modifyTime = e.modifyTime;
                this.householdNew.authStatus = e.authStatus;
                this.householdNew.idCardImage1 = e.idCardImage1;
                this.householdNew.idCardImage2 = e.idCardImage2;
                this.householdNew.currentImage = e.currentImage;
                this.householdNew.address = e.address;
                this.householdNew.status = e.status;
            },
            /*householdModify设置*/
            householdModifySet(e){
                this.householdModify.id = e.id;
                this.householdModify.houseId = e.houseId;
                this.householdModify.householdName = e.householdName;
                this.householdModify.sex = e.sex;
                this.householdModify.birthday = e.birthday;
                this.householdModify.identityType = e.identityType;
                this.householdModify.company = e.company;
                this.householdModify.department = e.department;
                this.householdModify.cardType = e.cardType;
                this.householdModify.cardNo = e.cardNo;
                this.householdModify.mobile = e.mobile;
                this.householdModify.createTime = e.createTime;
                this.householdModify.modifyTime = e.modifyTime;
                this.householdModify.authStatus = e.authStatus;
                this.householdModify.idCardImage1 = e.idCardImage1;
                this.householdModify.idCardImage2 = e.idCardImage2;
                this.householdModify.currentImage = e.currentImage;
                this.householdModify.address = e.address;
                this.householdModify.status = e.status;
            },
            /*得到表数据*/
            getTable(e) {
                this.axios({
                  method: 'get',
                  url: '/households',
                  params: {
                    'page':e.pageInfo.page,
                    'pageSize':e.pageInfo.pageSize,
                    'householdId':e.householdId
                  }
                }).then(function (response) {
                    this.data1=response.data.data;
                    this.total=response.data.totalCount;
                }.bind(this)).catch(function (error) {
                  //alert(error);
                });
            },
            /*搜索按钮点击事件*/
            search(){
                this.initPageInfo();
                this.getTable({
                    "pageInfo":this.pageInfo,
                    'householdId':this.householdId,
                    'householdName':this.householdName,
                    'houseNo':this.houseNo
                });   
            },
            /*分页点击事件*/
            pageSearch(e){
                this.pageInfo.page = e-1;
                this.getTable({  
                    "pageInfo":this.pageInfo,
                    'householdId':this.householdId,
                    'householdName':this.householdName,
                    'houseNo':this.houseNo
                });
            },
            /*新建点击触发事件*/
            openNewModal(){
                this.newModal = true;
                this.initHouseholdNew();
                this.data1.sort();
                this.count = 0;
                this.groupId = null;
            },
            /*新建modal的newOk点击事件*/
            newOk (householdNew) {
                this.$refs[householdNew].validate((valid) => {
                    if (valid) {
                        this.initHousehold();
                        this.householdSet(this.householdNew);
                        this.axios({
                            method: 'post',
                            url: '/households/household',
                            data: this.household
                        }).then(function (response) {
                            this.initHouseholdNew();
                            this.getTable({
                                "pageInfo":this.pageInfo,
                                'householdId':this.householdId
                            });
                            this.$Message.info('新建成功');
                        }.bind(this)).catch(function (error) {
                            //alert(error);
                        });  
                        this.newModal = false;
                    }else {
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                });
            },
            /*点击修改时判断是否只选择一个*/
            openModifyModal(){
                if(this.count > 1 || this.count < 1){
                    this.modifyModal= false; 
                    this.$Message.warning('请至少选择一项(且只能选择一项)');  
                }else{
                    this.modifyModal = true;
                }
            },
            /*修改modal的modifyOk点击事件*/
             modifyOk (householdModify) {
                this.$refs[householdModify].validate((valid) => {
                    if (valid) {
                        this.initHousehold();
                        this.householdSet(this.householdModify);
                        alert("id:"+this.household.id);
                        this.axios({
                          method: 'put',
                          url: '/households/'+this.household.id,
                          data: this.household
                        }).then(function (response) {
                            this.initHouseholdNew();
                            this.getTable({
                                "pageInfo":this.pageInfo,
                                'householdId':this.householdId
                            });
                            this.$Message.info('修改成功');
                        }.bind(this)).catch(function (error) {
                          //alert(error);
                        });  
                        this.modifyModal = false;
                    }else {
                        this.$Message.error('表单验证失败!');
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                });
            },
            /*modal的cancel点击事件*/
            cancel () {
                this.$Message.info('点击了取消');
            },
            /*table选择后触发事件*/
            change(e){
                if(e.length==1){
                    this.householdModifySet(e['0']);
                }
                this.setGroupId(e);              
            },
            /*通过选中的行设置groupId的值*/
            setGroupId(e){
                this.groupId=[];
                this.count=e.length;
                for (var i = 0; i <= e.length - 1; i++) {
                    this.groupId.push(e[i].id);
                }
            },
            /*删除table中选中的数据*/
            del(){
                if(this.groupId!=null && this.groupId!=""){
                    this.axios({
                      method: 'delete',
                      url: '/households',
                      data: this.groupId
                    }).then(function (response) {
                        this.getTable({
                            "pageInfo":this.pageInfo,
                            'householdId':this.householdId
                        });
                        this.groupId=null;
                        this.count=0;
                        this.$Message.info('删除成功');
                    }.bind(this)).catch(function (error) {
                        //alert(error);
                    });
                }
            },
            /*表格中双击事件*/
            dblclick(e){
                this.householdModifySet(e);
                this.modifyModal = true;
                this.data1.sort();
            }
        }
    }
</script>