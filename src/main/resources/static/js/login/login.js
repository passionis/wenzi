$(function () {
    var regExp = /^1[3|4|5|7|8]\d{9}$/;
    var $userAccount = $("#account"), $password = $("#password");

    /**
     * 登录事件
     * @param e
     */
    var loginEvent = function () {
        var account = $userAccount.val();
        if (!account) {
            layer.alert('用户名不能为空', {icon: 5});
            return false;
        }

        if (!regExp.test(account)) {
            layer.alert('请求输入正确账户名', {
                icon: 5,
                btn: ['确定'],
                title: "错误"
            });
            return false;
        }

        var password = $password.val();
        if (!password) {
            layer.alert("密码不能为空", {icon: 5})
            return false;
        }
    };

    $("#loginBtn").on("click", loginEvent);

    layui.use(['form'], function () {
        var form = layui.form;
        layer = layui.layer;
        // // 进行登录操作
        // form.on('submit(login)', function (data) {
        //     data = data.field;
        //     if (data.username == '') {
        //         layer.msg('用户名不能为空');
        //         return false;
        //     }
        //
        //     if (data.username.r)
        //         if (data.password == '') {
        //             layer.msg('密码不能为空');
        //             return false;
        //         }
        //     if (data.captcha == '') {
        //         layer.msg('验证码不能为空');
        //         return false;
        //     }
        //     layer.msg('登录成功', function () {
        //         // window.location = '/index.html';
        //     });
        //     return false;
        // });
    });
});