var vm = new Vue({
    el: "#main",
    data: {

    },
    methods: {
        upload: function(){
            var formData = new FormData();
            formData.append('file', $('#myfile')[0].files[0]);

            $.ajax({
                url: "/user/upload",
                method: "POST",
                processData: false,
                contentType: false,
                data: formData,
                success: function(data){

                }
            });
        }
    },
    mounted: function(){

    }
});