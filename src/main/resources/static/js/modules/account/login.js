
    new Vue({
        el: '.container',
        data:{
            username:'',
            password:''
        },
        methods:{
            login:function(){
                if($.trim(this.username) === '' || $.trim(this.password) === ''){
                    $('#modal').modal();
                    return;
                }
                $.ajax({
                    method:'POST',
                    url:'/home/login',
                    data:{
                        username: this.username,
                        password: this.password
                    },
                    success:function(data,status){
                        if(data.status == 200){
                            window.location.href='/modules/account/userlist.html';
                        }else{
                            if(data.status == 403){
                                window.location.href='/error/403.html';
                            }else{
                                alert(data.message);
                            }
                        }
                    },
                    error:function(){
                    }
                });
            }
        }
    });