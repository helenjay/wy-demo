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
                        <Form-item label="住户性别:" prop="gender">
                            <Input v-model="householdNew.gender" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="出生日期:" prop="birthDate">
                            <Input v-model="householdNew.birthDate" style="width: 204px"/>
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
                    <Form-item label="住户性别:" prop="gender">
                        <!--<Input v-model="householdModify.gender" style="width: 204px"/>-->
                        <RadioGroup v-model="householdModify.gender" style="width: 204px">
                            <Radio label="1">女</Radio>
                            <Radio label="2">男</Radio>
                            <Radio label="3">未知</Radio>
                        </RadioGroup>
                    </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="出生日期:" prop="birthDate">
                            <DatePicker type="date" placeholder="选择点击" style="width: 200px" v-model="householdModify.birthDate"></DatePicker>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <FormItem label="身份类型" prop="identityType">
                            <Select v-model="householdModify.identityType" placeholder="选择身份信息" style="width: 204px">
                                <Option value="1">业主</Option>
                                <Option value="2">家属</Option>
                                <Option value="3">租客</Option>
                            </Select>
                        </FormItem>
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
                        <!--<Input v-model="householdModify.cardType" style="width: 204px"/>-->
                        <Select v-model="householdModify.cardType" placeholder="选择证件类型" style="width: 204px">
                            <Option value="10">身份证</Option>
                            <Option value="14">普通护照</Option>
                            <Option value="15">驾驶证</Option>
                        </Select>
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
                        <!--<Input v-model="householdModify.idCardImage1" style="width: 204px"/>-->
                        <!--<Upload action="//jsonplaceholder.typicode.com/posts/">-->
                            <!--<Button type="ghost" icon="ios-cloud-upload-outline">Upload files</Button>-->
                        <!--</Upload>-->
                        <div class="demo-upload-list" v-for="item in uploadList">
                            <template v-if="item.status === 'finished'">
                                <img :src="item.url">
                                <div class="demo-upload-list-cover">
                                    <Icon type="ios-eye-outline" @click.native="handleView(item.name)"></Icon>
                                    <Icon type="ios-trash-outline" @click.native="handleRemove(item)"></Icon>
                                </div>
                            </template>
                            <template v-else>
                                <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress>
                            </template>
                        </div>
                        <Upload
                                ref="upload"
                                :show-upload-list="false"
                                :default-file-list="defaultList"
                                :on-success="handleSuccess"
                                :format="['jpg','jpeg','png']"
                                :max-size="2048"
                                :on-format-error="handleFormatError"
                                :on-exceeded-size="handleMaxSize"
                                :before-upload="handleBeforeUpload"
                                multiple
                                type="drag"
                                action="//jsonplaceholder.typicode.com/posts/"
                                style="display: inline-block;width:58px;">
                            <div style="width: 58px;height:58px;line-height: 58px;">
                                <Icon type="camera" size="20"></Icon>
                            </div>
                        </Upload>
                        <Modal title="View Image" v-model="visible">
                            <img :src="'https://o5wwk8baw.qnssl.com/' + imgName + '/large'" v-if="visible" style="width: 100%">
                        </Modal>
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
                    gender:null,
                    birthDate:null,
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
                    gender:null,
                    birthDate:null,
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
                    gender:null,
                    birthDate:null,
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
                        key: 'gender',
                        render:(h, params) => {
//                            return h('div',
//                                new Date(this.row.lastUpdate).Format('yyyy-MM-dd'));
                            if(this.row.gender == 1) {
                                return "男";
                            }else{
                                return "女";
                            }
                        }
                    },
                    {
                        title: '出生日期',
                        key: 'birthDate'
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
                data1: [],
                /*上传图片定义*/
                defaultList: [
                    {
                        'name': 'a42bdcc1178e62b4694c830f028db5c0',
                        'url': 'https://o5wwk8baw.qnssl.com/a42bdcc1178e62b4694c830f028db5c0/avatar'
                    },
                    {
                        'name': 'bc7521e033abdd1e92222d733590f104',
                        'url': 'https://o5wwk8baw.qnssl.com/bc7521e033abdd1e92222d733590f104/avatar'
                    }
                ],
                imgName: '',
                visible: false,
                uploadList: []
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
                this.household.gender = null;
                this.household.birthDate = null;
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
                this.householdNew.gender = null;
                this.householdNew.birthDate = null;
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
                this.householdModify.gender = null;
                this.householdModify.birthDate = null;
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
                this.household.gender = e.gender;
                this.household.birthDate = e.birthDate;
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
                this.householdNew.gender = e.gender;
                this.householdNew.birthDate = e.birthDate;
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
                this.householdModify.gender = e.gender;
                this.householdModify.birthDate = e.birthDate;
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
            },
            /*图片上传 start */
            handleView (name) {
                this.imgName = name;
                this.visible = true;
            },
            handleRemove (file) {
                const fileList = this.$refs.upload.fileList;
                this.$refs.upload.fileList.splice(fileList.indexOf(file), 1);
            },
            handleSuccess (res, file) {
                file.url = 'https://o5wwk8baw.qnssl.com/7eb99afb9d5f317c912f08b5212fd69a/avatar';
                file.name = '7eb99afb9d5f317c912f08b5212fd69a';
            },
            handleFormatError (file) {
                this.$Notice.warning({
                    title: 'The file format is incorrect',
                    desc: 'File format of ' + file.name + ' is incorrect, please select jpg or png.'
                });
            },
            handleMaxSize (file) {
                this.$Notice.warning({
                    title: 'Exceeding file size limit',
                    desc: 'File  ' + file.name + ' is too large, no more than 2M.'
                });
            },
            handleBeforeUpload () {
                const check = this.uploadList.length < 5;
                if (!check) {
                    this.$Notice.warning({
                        title: 'Up to five pictures can be uploaded.'
                    });
                }
                return check;
            }
        }
    }
</script>

<style>

    .demo-upload-list{
        display: inline-block;
        width: 60px;
        height: 60px;
        text-align: center;
        line-height: 60px;
        border: 1px solid transparent;
        border-radius: 4px;
        overflow: hidden;
        background: #fff;
        position: relative;
        box-shadow: 0 1px 1px rgba(0,0,0,.2);
        margin-right: 4px;
    }
    .demo-upload-list img{
        width: 100%;
        height: 100%;
    }
    .demo-upload-list-cover{
        display: none;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background: rgba(0,0,0,.6);
    }
    .demo-upload-list:hover .demo-upload-list-cover{
        display: block;
    }
    .demo-upload-list-cover i{
        color: #fff;
        font-size: 20px;
        cursor: pointer;
        margin: 0 2px;
    }


</style>