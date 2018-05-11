
var vm = new Vue({
    el: ".container",
    data: {
        users:[]
    },
    created: function(){
        this.getUserList();
    },
    mounted: function(){
        this.$nextTick(function(){
            //this.getUserList();
        })
    },
    methods: {
        getUserList:function(){
            var self = this;
            $.ajax({
                url: "/user/list",
                method: "GET",
                data: {},
                success: function(res, status){
                    if(res.status === 200){
                        self.users = res.data;
                    }
                },
                error: function(){
                }
            });
        }
    }
});