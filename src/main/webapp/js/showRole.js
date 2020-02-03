layui.use(['table','form','laydate'],function () {
    //创建出内置模块的对象(layer不需要显示在js文件中写出,jquery在layui单独使用要写$ = layui.$)
    var table = layui.table,
        form = layui.form,
        laydate = layui.laydate;

    table.render({
        elem: '#demo'
        , height: 512
        , url: 'role/loadPageTByPramas' //数据接口
        , limit: 3
        , limits: [2, 3, 5, 8, 10, 15]
        , page: true //开启分页
        , even: true
        , cols: [[ //表头
            {type: 'checkbox'}
            , {field: 'id', title: 'ID', width: 80, align: 'center', sort: true}
            , {field: 'roleName', title: '角色名称', align: 'center', width: 140}
            , {field: 'authNames', title: '角色权限', align: 'center', width: 680}
            , {field: 'createDate', title: '创建时间', align: 'center', width: 250, sort: true}
            , {field: 'status', title: '是否可用', align: 'center', sort: true, width: 155, sort: true,templet: '#statusTpl'}
            , {field: 'flag', title: '是否显示', align: 'center', sort: true, width: 155, sort: true,templet: '#flagTpl'}
            , {fixed: 'right', width: 110, title: '操作', align: 'center', toolbar: '#barDemo'}
        ]]
    });

    //监听表格的工具条
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        if (layEvent === 'detail'){ //查看角色的权限
            //1.将权限的树型数据添加到树型容器中
            //根据角色id查询其所拥有的权限
            loadZtree("auth/loadAuthByRoleId?roleId="+data.id);
            //2.弹框
            layer.open({
                type:1,
                title:'权限树型信息界面',
                area:['380px','500px'],
                shade:0.5,
                content:$("#ztreeDiv"),
                anim:4,
                cancel:function (index) {  //关闭的函数回调
                    $("#ztreeDiv").hide();  //将树型结构的div重新隐藏
                    layer.close(index);
                }
            });
        }
    });


    /**********************************自定义的方法*************************/
    //加载角色的权限树形图
    function loadZtree(dataUrl) {
        var setting = {
            data : {   //设置节点数据
                simpleData : {
                    enable : true,   //使用格式化后的数据
                    idKey : "id",       // 结点的id,对应到Json中的id
                    pIdKey : "parent",     // 结点的pId(指向节点id),父节点id,对应到Json中的pid
                    rootPId : 0         // 根节点上的节点，设置为0节点（实际此节点是不存在）
                },
                key : {
                    name : "authorityName" // 结点显示的name属性，节点的名字，对应到Json中的rName
                }
            },
            check: {
                enable: true   //是否使用节点复选框，开启，默认为false(不使用)
            },
            async : {
                enable : true,  //使用异步数据：从服务器端获取数据
                url:dataUrl,    //服务器端访问路径
                autoParam:["id", "name=n", "level=lv"],  //能否自动加载
                otherParam:{"otherParam":"zTreeAsyncTest"}  //异步数据的样式设置
            }
        };
        $.fn.zTree.init($("#test1"), setting);  //树形结构的数据初始化
    }





});