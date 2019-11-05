$(function () {
    var regExp = /^1[3|4|5|7|8]\d{9}$/;
    var $userAccount = $("#account"), $password = $("#password");

    /**
     * 登录事件
     * @param e
     */
    var loginEvent = function (e) {
        var account = $userAccount.val();
        if (!account) {
            layer.alert('用户名不能为空', {icon: 5});
            return;
        }

        // if (!regExp.test(account)) {
        //     layer.alert('请求输入正确账户名', {
        //         icon: 5,
        //         btn: ['确定'],
        //         title: "错误"
        //     });
        //     return;
        // }

        var password = $password.val();
        if (!password) {
            layer.alert("密码不能为空", {icon: 5})
            return;
        }
        $(".layui-form").submit();
    };

    $("#loginBtn").on("click", loginEvent);

    layui.use(['form'], function () {
        var form = layui.form;
        layer = layui.layer;
        if (data.msg) {
            layer.alert(data.msg,{icon:5,title:'提示',btn:["确认"]});
        }
    });





});